package com.graphisoft.ecotech.controller;

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

}
