package com.graphisoft.ecotech.service;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.User;
import com.graphisoft.ecotech.utils.ResponseModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    User loginUser(String userName);

    ResponseModel createUser(UserDTO userDTO);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
