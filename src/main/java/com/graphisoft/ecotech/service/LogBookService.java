package com.graphisoft.ecotech.service;

import com.graphisoft.ecotech.dto.LogBookDTO;
import com.graphisoft.ecotech.utils.ResponseModel;

public interface LogBookService {

    ResponseModel createLogBook(LogBookDTO logBookDTO);

    ResponseModel findByIdSolicitud(Long idSolicitud);
}
