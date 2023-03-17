package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.OrderEjecution;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderEjecutionRepository extends JpaRepository<OrderEjecution, Long> {

  /*  @Query(value = "select * from ejecucion_orden where (id_solicitud = :idSolicitud)", nativeQuery = true)
    List<OrderEjecution> findByOrderEjecution(Long idSolicitud, Long idUsuario, Long idEmpresa);*/
}
