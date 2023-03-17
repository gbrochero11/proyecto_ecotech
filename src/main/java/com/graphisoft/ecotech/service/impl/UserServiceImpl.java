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
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseModel createUser(UserDTO userDTO) {
        User user = userRepository.findByDocumento(userDTO.getDocumento().toString());
        if(user != null){
            return new ResponseModel(Time.getTime(), "", 422, "Ya se encuentra usuario registrado.");
        }
        user= CustomMapper.mapObject(userDTO,User.class);
        userRepository.save(user);
        return new ResponseModel(Time.getTime(), user, 204, "Registro de usuario exitoso.");
    }

    public ResponseModel loginUser(String userName, String password) {

        User user = userRepository.findByUserAndPassword(userName,password);
        if(user != null){
            return new ResponseModel(Time.getTime(), user, 200, "Ingreso exitoso.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos incorrectos. Verifique su usuario y/o contraseña.");
    }
}
