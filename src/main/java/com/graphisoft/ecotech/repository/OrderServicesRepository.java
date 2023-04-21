package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
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

    @Query(value = "select * from solicitud_servicios where (id_recurso = :id) and (codigo_estado != 5)", nativeQuery = true)
    List<OrderService> findByIdRecurso(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE OrderService  SET id_recurso = :idRecurso, codigo_estado =  :codigoEstado WHERE id = :idSolicitud")
    int actualizarRecurso(@Param("idSolicitud") Long id, @Param("idRecurso") Long idRecurso, @Param("codigoEstado") Long codigoEstado);

    @Transactional
    @Modifying
    @Query("UPDATE OrderService  SET id_recurso = :idRecurso WHERE id = :idSolicitud")
    int asignarServicioRecurso(@Param("idSolicitud") Long id, @Param("idRecurso") Long idRecurso);

    @Query(value = "select * from solicitud_servicios where (documento_empresa = :identification) and (id_recurso is null)", nativeQuery = true)
    List<OrderService> findByOrderServicesNotAssigned(String identification);

    @Query(value = "select * from solicitud_servicios where (id = :id)", nativeQuery = true)
    List<OrderService> findByServicioID(Long id);

}
