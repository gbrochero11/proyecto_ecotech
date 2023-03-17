package com.graphisoft.ecotech.controller;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.service.UserService;
import com.graphisoft.ecotech.utils.ResponseModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> create( @RequestBody UserDTO userDTO) {
        ResponseModel response = userService.createUser(userDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login-user")
    public ResponseEntity<?> loginUser(
            @ApiParam(name = "userName", value = "Numeric values for userName")
            @RequestParam String userName,
            @ApiParam(name = "password", value = "Numeric values for password")
            @RequestParam(defaultValue = "0") String password) {
        ResponseModel response = userService.loginUser(userName, password);
        return ResponseEntity.ok(response);
    }
}
