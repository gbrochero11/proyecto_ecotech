package com.graphisoft.ecotech.controller;

import com.graphisoft.ecotech.dto.UserAppDTO;
import com.graphisoft.ecotech.dto.UserDTO;
import com.graphisoft.ecotech.model.UserApp;
import com.graphisoft.ecotech.service.UserAppService;
import com.graphisoft.ecotech.utils.ResponseModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-app")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserAppController {


    @Autowired
    private UserAppService userAppService;

    @PostMapping("/register")
    public ResponseEntity<?> create( @RequestBody UserAppDTO userDTO) {
        ResponseModel response = userAppService.createUser(userDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login-app")
    public ResponseEntity<?> loginUser(
            @ApiParam(name = "userName", value = "Numeric values for userName")
            @RequestParam String userName,
            @ApiParam(name = "password", value = "Numeric values for password")
            @RequestParam(defaultValue = "0") String password) {
        ResponseModel response = userAppService.loginUserApp(userName, password);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order-services-assigned")
    public ResponseEntity<?> orderServicesAll(
            @ApiParam(name = "idResource", value = "Numeric values for resource id")
            @RequestParam Long idResource) {
        ResponseModel response = userAppService.orderServicesAssigned(idResource);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/userapp-company")
    public ResponseEntity<?> usersAppCompany(
            @ApiParam(name = "idCompany", value = "Numeric values for company id")
            @RequestParam String idCompany) {
        
        ResponseModel response = userAppService.userAssignedCompany(Long.parseLong(idCompany));
        return ResponseEntity.ok(response);
    }

}
