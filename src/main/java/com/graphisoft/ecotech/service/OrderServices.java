package com.graphisoft.ecotech.service;

import com.graphisoft.ecotech.dto.OrderServiceDTO;
import com.graphisoft.ecotech.utils.ResponseModel;

public interface OrderServices {

    ResponseModel createOrder(OrderServiceDTO orderServiceDTO);

    ResponseModel deleteOrder(Long idOrder);

    ResponseModel updateOrder(OrderServiceDTO orderServiceDTO);

    ResponseModel findByOrderServiceAllDocument(String document);

    ResponseModel findByOrderServiceCodeState(String document, Long codeState);

    ResponseModel findOrderServiceAvaible();

    ResponseModel findByOrderServicesAccepted(String document);
}
