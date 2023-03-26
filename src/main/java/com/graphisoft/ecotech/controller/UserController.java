package com.graphisoft.ecotech.controller;

import com.google.gson.Gson;
import com.graphisoft.ecotech.config.*;
import com.graphisoft.ecotech.dto.LoginDTO;
import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.User;
import com.graphisoft.ecotech.service.UserService;
import com.graphisoft.ecotech.utils.ResponseModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtToken jwtToken;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @PostMapping("/register")
    public ResponseEntity<?> create( @RequestBody UserDTO userDTO) {
        ResponseModel response = userService.createUser(userDTO);
        return ResponseEntity.ok(response);
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        byte[] bytesDecodificados = Base64.getDecoder().decode(authenticationRequest.getPassword());
        String cadenaDecodificada = new String(bytesDecodificados);
        authenticate(authenticationRequest.getUsername(), cadenaDecodificada);
        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        User user = userService.loginUser(authenticationRequest.getUsername());
        final String token = jwtToken.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token, user.getId(), user.getDocumento(), user.getTipoUsuario(), user.getNombre()));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
