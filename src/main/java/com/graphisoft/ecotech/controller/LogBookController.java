package com.graphisoft.ecotech.controller;


import com.graphisoft.ecotech.dto.LogBookDTO;
import com.graphisoft.ecotech.service.LogBookService;
import com.graphisoft.ecotech.utils.ResponseModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logbook")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class LogBookController {

    @Autowired
    private LogBookService logBookService;

    @PostMapping("/register-logbook")
    public ResponseEntity<?> create(@RequestBody LogBookDTO logBookDTO) {
        ResponseModel response = logBookService.createLogBook(logBookDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/logbook-id")
    public ResponseEntity<?> orderServicesAll(
            @ApiParam(name = "idSolicitud", value = "Numeric values for id")
            @RequestParam Long idSolicitud) {
        ResponseModel response = logBookService.findByIdSolicitud(idSolicitud);
        return ResponseEntity.ok(response);
    }
}
