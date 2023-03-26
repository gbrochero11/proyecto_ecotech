package com.graphisoft.ecotech.service.impl;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.User;
import com.graphisoft.ecotech.repository.UserRepository;
import com.graphisoft.ecotech.service.UserService;
import com.graphisoft.ecotech.utils.CustomMapper;
import com.graphisoft.ecotech.utils.ResponseModel;
import com.graphisoft.ecotech.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;


@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public ResponseModel createUser(UserDTO userDTO) {
        User user = userRepository.findByDocumento(userDTO.getDocumento().toString());
        if(user != null){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra usuario registrado.");
        }
        byte[] bytesDecodificados = Base64.getDecoder().decode(userDTO.getPassword_app());
        String cadenaDecodificada = new String(bytesDecodificados);
        String password = cadenaDecodificada;
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        userDTO.setPassword_app(encodedPassword);
        user= CustomMapper.mapObject(userDTO,User.class);
        userRepository.save(user);
        return new ResponseModel(Time.getTime(), user, 204, "Registro de usuario exitoso.");
    }

    public User loginUser(String userName) {

        User user = userRepository.findByUsuarioApp(userName);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsuarioApp(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsuarioApp(), user.getPasswordApp(),
                new ArrayList<>());
    }
}
