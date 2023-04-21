package com.graphisoft.ecotech.controller;

import com.graphisoft.ecotech.dto.AssignedResource;
import com.graphisoft.ecotech.dto.OrderServiceDTO;
import com.graphisoft.ecotech.service.OrderServices;
import com.graphisoft.ecotech.utils.ResponseModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderservice")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class OrderServiceController {

    @Autowired
    private OrderServices orderServices;

    @PostMapping("/registerorder")
    public ResponseEntity<?> create(@RequestBody OrderServiceDTO orderServiceDTO) {
        ResponseModel response = orderServices.createOrder(orderServiceDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-order")
    public ResponseEntity<?> update(@RequestBody OrderServiceDTO orderServiceDTO) {
        ResponseModel response = orderServices.updateOrder(orderServiceDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-order/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        ResponseModel response = orderServices.deleteOrder(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order-services-document")
    public ResponseEntity<?> orderServicesAll(
            @ApiParam(name = "document", value = "Numeric values for document")
            @RequestParam String document) {
        ResponseModel response = orderServices.findByOrderServiceAllDocument(document);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order-code-state")
    public ResponseEntity<?> orderServicesAllCodeState(
            @ApiParam(name = "document", value = "Numeric values for document")
            @RequestParam String document,
            @ApiParam(name = "codeState", value = "Numeric values for codeState")
            @RequestParam Long codeState) {
        ResponseModel response = orderServices.findByOrderServiceCodeState(document, codeState);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order-service-avaible")
    public ResponseEntity<?> orderServicesAvaible() {
        ResponseModel response = orderServices.findOrderServiceAvaible();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order-oferrs-accepted")
    public ResponseEntity<?> orderServicesAccepted(
            @ApiParam(name = "document", value = "Numeric values for document")
            @RequestParam String document) {
        ResponseModel response = orderServices.findByOrderServicesAccepted(document);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-resource")
    public ResponseEntity<?> updateResource(@RequestBody AssignedResource orderServiceDTO) {
        ResponseModel response = orderServices.asignarServicioRecurso(orderServiceDTO.getId(), orderServiceDTO.getId_recurso());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/oferrs-not-assigned")
    public ResponseEntity<?> orderServicesNotAssigned(
            @ApiParam(name = "document", value = "Numeric values for document")
            @RequestParam String document) {
        ResponseModel response = orderServices.findByOrderServicesNotAssigned(document);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/company-associated-horeca")
    public ResponseEntity<?> companyAssociatedHoreca(
            @ApiParam(name = "id", value = "Numeric values for id")
            @RequestParam Long id) {
        ResponseModel response = orderServices.companyAssociatedHoreca(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/company-associated-empresa")
    public ResponseEntity<?> companyAssociatedEmpresa(
            @ApiParam(name = "id", value = "Numeric values for id")
            @RequestParam Long id) {
        ResponseModel response = orderServices.companyAssociatedEmpresa(id);
        return ResponseEntity.ok(response);
    }

}
