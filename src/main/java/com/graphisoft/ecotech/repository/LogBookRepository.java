package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.LogBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogBookRepository  extends JpaRepository<LogBook, Long> {

    @Query(value = "select * from bitacora_servicio where (id_solicitud = :idSolicitud) ORDER BY estado_servicio ASC", nativeQuery = true)
    List<LogBook> findById_solicitud(Long idSolicitud);
}
