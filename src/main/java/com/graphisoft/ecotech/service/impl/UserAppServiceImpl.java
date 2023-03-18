package com.graphisoft.ecotech.service.impl;

import com.graphisoft.ecotech.dto.OrderServiceDTO;
import com.graphisoft.ecotech.dto.UserAppDTO;
import com.graphisoft.ecotech.model.OrderService;
import com.graphisoft.ecotech.model.User;
import com.graphisoft.ecotech.model.UserApp;
import com.graphisoft.ecotech.repository.OrderServicesRepository;
import com.graphisoft.ecotech.repository.UserAppRepository;
import com.graphisoft.ecotech.repository.UserRepository;
import com.graphisoft.ecotech.service.UserAppService;
import com.graphisoft.ecotech.utils.ResponseModel;
import com.graphisoft.ecotech.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private OrderServicesRepository orderServicesRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseModel loginUserApp(String userName, String password) {

        UserApp user = userAppRepository.findLoginResource(userName,password);
        if(user != null){
            return new ResponseModel(Time.getTime(), user, 200, "Ingreso exitoso.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos incorrectos. Verifique su usuario y/o contraseña.");
    }

    public ResponseModel orderServicesAssigned(Long idResource) {

        List<UserAppDTO> mapService = new ArrayList<UserAppDTO>();
        List<OrderService> orderService = orderServicesRepository.findByIdRecurso(idResource);
        User user = userRepository.findByDocumento(orderService.get(0).getDocumento_usuario());
        for (int i=0; i<orderService.size(); i++){
            UserAppDTO orderServiceDTO = new UserAppDTO();
            orderServiceDTO.setIdService(orderService.get(i).getId());
            orderServiceDTO.setCiudad_origen(orderService.get(i).getCiudad_origen());
            orderServiceDTO.setDireccion(orderService.get(i).getDireccion());
            orderServiceDTO.setToneladas(orderService.get(i).getToneladas());
            orderServiceDTO.setFecha_solicitud(orderService.get(i).getFecha_solicitud());
            orderServiceDTO.setTelefono(orderService.get(i).getTelefono());
            orderServiceDTO.setNombre(user.getNombre());
            orderServiceDTO.setCodigo_rut(user.getCodigo_rut());
            mapService.add(orderServiceDTO);
        }

        if(!mapService.isEmpty() && mapService.size() > 0){
            return new ResponseModel(Time.getTime(), mapService, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }


}
