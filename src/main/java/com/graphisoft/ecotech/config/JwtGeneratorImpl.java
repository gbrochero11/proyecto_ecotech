package com.graphisoft.ecotech.config;

import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtGeneratorImpl implements JwtGeneratorInterface{

    @Value("${security.jwt.token.secret-key}")
    private String secret;
    @Value("${security.jwt.token.expire-length}")
    private String message;
    @Override
    public Map<String, String> generateToken(User user) {
        String jwtToken="";
        jwtToken = Jwts.builder().setSubject(user.getUsuarioApp()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("message", message);
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("user", user.getUsuarioApp());
        jwtTokenGen.put("tipousuario", String.valueOf(user.getTipoUsuario()));
        return jwtTokenGen;
    }
}
