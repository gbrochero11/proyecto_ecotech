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

        if (userDTO != null && userDTO.getNombre().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo nombre no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getDocumento().toString().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo documento no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getUsuarioApp().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo usuario no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getPasswordApp().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo contraseña no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getCorreoElectronico().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo correo electronico no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getDireccion().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo dirección no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getCodigoRut().toString().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo codigo rut no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getCiudad().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo ciudad no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getRazon_social().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo razon social no puede estar vacio.");
        }

        if (userDTO != null && userDTO.getRepresentante().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo representate no puede estar vacio.");
        }

        User user = userRepository.findByDocumento(userDTO.getDocumento().toString(),
                userDTO.getCorreoElectronico(), userDTO.getUsuarioApp());

        if(user != null && user.getDocumento().equals(userDTO.getDocumento())){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra documento registrado.");
        }

        if(user != null && user.getCorreoElectronico().equalsIgnoreCase(userDTO.getCorreoElectronico())){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra correo registrado.");
        }

        if(user != null && user.getUsuarioApp().equalsIgnoreCase(userDTO.getUsuarioApp())){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra usuario registrado.");
        }

        if(user != null){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra usuario registrado.");
        }
        byte[] bytesDecodificados = Base64.getDecoder().decode(userDTO.getPasswordApp());
        String cadenaDecodificada = new String(bytesDecodificados);
        String password = cadenaDecodificada;
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        userDTO.setPasswordApp(encodedPassword);
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
