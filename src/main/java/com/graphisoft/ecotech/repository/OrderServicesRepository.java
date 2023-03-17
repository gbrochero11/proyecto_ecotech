package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderServicesRepository  extends JpaRepository<OrderService, Long> {

    @Query(value = "select * from solicitud_servicios where (documento_usuario = :identification)", nativeQuery = true)
    List<OrderService> findByDocumento_usuario(String identification);

    @Query(value = "select * from solicitud_servicios where (codigo_estado = :codeState) and (documento_usuario = :identification)", nativeQuery = true)
    List<OrderService> findByCodigo_estado(String identification, Long codeState);

    @Query(value = "select * from solicitud_servicios where (codigo_estado = :codeState)", nativeQuery = true)
    List<OrderService> findOrderServiceAvaible(Long codeState);

    @Query(value = "select * from solicitud_servicios where (documento_empresa = :identification)", nativeQuery = true)
    List<OrderService> findByOrderServicesAccepted(String identification);
}
