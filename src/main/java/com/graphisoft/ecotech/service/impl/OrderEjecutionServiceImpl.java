package com.graphisoft.ecotech.service.impl;

import com.graphisoft.ecotech.dto.LogBookDTO;
import com.graphisoft.ecotech.dto.OrderEjecutionDTO;
import com.graphisoft.ecotech.model.LogBook;
import com.graphisoft.ecotech.model.OrderEjecution;
import com.graphisoft.ecotech.repository.OrderEjecutionRepository;
import com.graphisoft.ecotech.service.OrderEjecutionService;
import com.graphisoft.ecotech.utils.CustomMapper;
import com.graphisoft.ecotech.utils.ResponseModel;
import com.graphisoft.ecotech.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEjecutionServiceImpl implements OrderEjecutionService {

    @Autowired
    OrderEjecutionRepository orderEjecutionRepository;

    public ResponseModel createOrderEjecution(OrderEjecutionDTO orderEjecutionDTO) {

        OrderEjecution orderEjecution = CustomMapper.mapObject(orderEjecutionDTO, OrderEjecution.class);
        orderEjecutionRepository.save(orderEjecution);
        return new ResponseModel(Time.getTime(), orderEjecution, 200, "Registro de servicio ejecucion exitoso.");
    }
}
