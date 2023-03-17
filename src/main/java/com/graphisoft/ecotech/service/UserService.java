package com.graphisoft.ecotech.service;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.utils.ResponseModel;

public interface UserService {

    ResponseModel loginUser(String userName, String password);

    ResponseModel createUser(UserDTO userDTO);

}
