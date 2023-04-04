package com.graphisoft.ecotech.service.impl;

import com.graphisoft.ecotech.dto.OrderServiceDTO;
import com.graphisoft.ecotech.model.OrderService;
import com.graphisoft.ecotech.model.User;
import com.graphisoft.ecotech.repository.OrderServicesRepository;
import com.graphisoft.ecotech.repository.UserRepository;
import com.graphisoft.ecotech.service.OrderServices;
import com.graphisoft.ecotech.utils.CustomMapper;
import com.graphisoft.ecotech.utils.ResponseModel;
import com.graphisoft.ecotech.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServicesImpl implements OrderServices {

    @Autowired
    private OrderServicesRepository orderServicesRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseModel createOrder(OrderServiceDTO orderServiceDTO) {

        if (orderServiceDTO != null && orderServiceDTO.getDireccion().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo Dirección rut no puede estar vacio.");
        }

        if (orderServiceDTO != null && orderServiceDTO.getCiudad_origen().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo Ciudad no puede estar vacio.");
        }

        if (orderServiceDTO != null && orderServiceDTO.getTelefono().toString().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo Telefono no puede estar vacio.");
        }

        if (orderServiceDTO != null && orderServiceDTO.getFecha_solicitud().trim().isEmpty()){
            return new ResponseModel(Time.getTime(), "", 422, "El campo Fecha no puede estar vacio.");
        }

        OrderService orderServiceDB = CustomMapper.mapObject(orderServiceDTO, OrderService.class);
        orderServiceDB.setCodigo_estado(1L);
        orderServicesRepository.save(orderServiceDB);
        return new ResponseModel(Time.getTime(), orderServiceDB, 200, "Registro de orden exitoso.");
    }

    public ResponseModel deleteOrder(Long idOrder) {

        orderServicesRepository.deleteById(idOrder);
        return new ResponseModel(Time.getTime(), "", 200, "Registro eliminado exitosamente.");
    }

    public ResponseModel updateOrder(OrderServiceDTO orderServiceDTO) {

        OrderService orderServiceDB = CustomMapper.mapObject(orderServiceDTO, OrderService.class);
        orderServicesRepository.saveAndFlush(orderServiceDB);
        return new ResponseModel(Time.getTime(), orderServiceDB, 200, "Registro eliminado exitosamente.");
    }

    public ResponseModel findByOrderServiceAllDocument(String document) {

        List<OrderService> orderServiceList = orderServicesRepository.findByDocumento_usuario(document);
        if(!orderServiceList.isEmpty() && orderServiceList.size() > 0){
            return new ResponseModel(Time.getTime(), orderServiceList, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }

    public ResponseModel findByOrderServiceCodeState(String document, Long codeState) {

        List<OrderService> orderServiceList = orderServicesRepository.findByCodigo_estado(document, codeState);
        if(!orderServiceList.isEmpty() && orderServiceList.size() > 0){
            return new ResponseModel(Time.getTime(), orderServiceList, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }

    public ResponseModel findOrderServiceAvaible() {
        List<OrderServiceDTO> mapService = new ArrayList<OrderServiceDTO>();
        List<OrderService> orderServiceList = orderServicesRepository.findOrderServiceAvaible(1L);
        for (int i=0; i<orderServiceList.size(); i++){
            User user = userRepository.findByDocumento(orderServiceList.get(i).getDocumento_usuario());
            OrderServiceDTO orderServiceDTO = new OrderServiceDTO();
            orderServiceDTO.setId(orderServiceList.get(i).getId());
            orderServiceDTO.setDocumento_usuario(orderServiceList.get(i).getDocumento_usuario());
            orderServiceDTO.setCodigo_estado(orderServiceList.get(i).getCodigo_estado());
            orderServiceDTO.setDireccion(orderServiceList.get(i).getDireccion());
            orderServiceDTO.setToneladas(orderServiceList.get(i).getToneladas());
            orderServiceDTO.setNombre_horeca(user.getNombre());
            orderServiceDTO.setCiudad_origen(orderServiceList.get(i).getCiudad_origen());
            orderServiceDTO.setFecha_solicitud(orderServiceList.get(i).getFecha_solicitud());
            orderServiceDTO.setTelefono(orderServiceList.get(i).getTelefono());
            mapService.add(orderServiceDTO);
        }

        if(!orderServiceList.isEmpty() && orderServiceList.size() > 0){
            return new ResponseModel(Time.getTime(), mapService, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }

    public ResponseModel findByOrderServicesAccepted(String document) {

        List<OrderService> orderServiceList = orderServicesRepository.findByOrderServicesAccepted(document);
        if(!orderServiceList.isEmpty() && orderServiceList.size() > 0){
            return new ResponseModel(Time.getTime(), orderServiceList, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }

    public ResponseModel asignarServicioRecurso(Long id, Long idRecurso) {

        int assignedResource = orderServicesRepository.asignarServicioRecurso(id, idRecurso);
        if(assignedResource > 0){
            return new ResponseModel(Time.getTime(), assignedResource, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }

    public ResponseModel findByOrderServicesNotAssigned(String document) {

        List<OrderService> orderServiceList = orderServicesRepository.findByOrderServicesNotAssigned(document);
        if(!orderServiceList.isEmpty() && orderServiceList.size() > 0){
            return new ResponseModel(Time.getTime(), orderServiceList, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }
}
