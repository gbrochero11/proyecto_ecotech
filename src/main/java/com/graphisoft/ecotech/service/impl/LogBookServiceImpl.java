package com.graphisoft.ecotech.service.impl;

import com.graphisoft.ecotech.dto.LogBookDTO;
import com.graphisoft.ecotech.model.LogBook;
import com.graphisoft.ecotech.model.TypeState;
import com.graphisoft.ecotech.repository.LogBookRepository;
import com.graphisoft.ecotech.repository.OrderServicesRepository;
import com.graphisoft.ecotech.repository.TypeStateRepository;
import com.graphisoft.ecotech.service.LogBookService;
import com.graphisoft.ecotech.utils.CustomMapper;
import com.graphisoft.ecotech.utils.ResponseModel;
import com.graphisoft.ecotech.utils.Time;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LogBookServiceImpl implements LogBookService {

    @Autowired
    private LogBookRepository logBookRepository;

    @Autowired
    private TypeStateRepository typeStateRepository;

    @Autowired
    private OrderServicesRepository orderServicesRepository;


    public ResponseModel createLogBook(LogBookDTO logBookDTO) {

        LogBook orderServiceDB = CustomMapper.mapObject(logBookDTO, LogBook.class);
        if(logBookRepository.save(orderServiceDB) != null){
            Long stateService= orderServiceDB.getEstado_servicio() + 1L;
            if (stateService != 5) {
                orderServicesRepository.actualizarRecurso(orderServiceDB.getId_solicitud(), null, stateService);
            }else{
                orderServicesRepository.actualizarRecurso(orderServiceDB.getId_solicitud(), orderServiceDB.getId_recurso(), stateService);
            }
        }
        return new ResponseModel(Time.getTime(), orderServiceDB, 200, "Registro de bitacora exitoso.");
    }

    public ResponseModel findByIdSolicitud(Long idSolicitud) {
        List<LogBookDTO> mapLogBook = new ArrayList<LogBookDTO>();
        List<LogBook> logBookList = logBookRepository.findById_solicitud(idSolicitud);

        for (int i=0; i<logBookList.size(); i++){
            Optional<TypeState> typeState= typeStateRepository.findById(logBookList.get(i).getEstado_servicio());
            LogBookDTO logBookDTO= new LogBookDTO();
            logBookDTO.setId(logBookList.get(i).getId());
            logBookDTO.setId_solicitud(logBookList.get(i).getId_solicitud());
            logBookDTO.setDescripcion(logBookList.get(i).getDescripcion());
            logBookDTO.setEstado_servicio(logBookList.get(i).getEstado_servicio());
            logBookDTO.setFecha_registro(logBookList.get(i).getFecha_registro());
            logBookDTO.setNombre_servicio(typeState.get().getNombre_estado());
            logBookDTO.setToneladas(logBookList.get(i).getToneladas());
            logBookDTO.setTipo_desecho(logBookList.get(i).getTipo_desecho());
            logBookDTO.setCantidad(logBookList.get(i).getCantidad());
            logBookDTO.setEmpresa_entrega(logBookList.get(i).getEmpresa_entrega());
            logBookDTO.setEmpresa_recibe(logBookList.get(i).getEmpresa_recibe());
            logBookDTO.setObservaciones(logBookList.get(i).getObservaciones());
            mapLogBook.add(logBookDTO);
        }

        if(!logBookList.isEmpty() && logBookList.size() > 0){

            return new ResponseModel(Time.getTime(), mapLogBook, 200, "Datos encontrados.");
        }
        return new ResponseModel(Time.getTime(), "", 404, "Datos no encontrados.");
    }
}
