package com.graphisoft.ecotech.repository;


import com.graphisoft.ecotech.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    @Query(value = "select * from recursos_empresas where (usuarioapp = :user) and (contrasenaapp = :password)", nativeQuery = true)
    UserApp findLoginResource(@Param("user") String user, @Param("password") String password);
    @Query(value = "select * from recursos_empresas where (id = :id)", nativeQuery = true)
    UserApp findResourceId(@Param("id") Long id);

    @Query(value = "select * from recursos_empresas where (id_empresa = :id)", nativeQuery = true)
    List<UserApp> findResourcesEmpresa(@Param("id") Long id);

}
