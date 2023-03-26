package com.graphisoft.ecotech.config;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.User;

import java.util.Map;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);

}
