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

    ResponseModel asignarServicioRecurso(Long id, Long idRecurso);

    ResponseModel findByOrderServicesNotAssigned(String document);

    ResponseModel companyAssociatedHoreca(Long id);

    ResponseModel companyAssociatedEmpresa(Long id);

}
