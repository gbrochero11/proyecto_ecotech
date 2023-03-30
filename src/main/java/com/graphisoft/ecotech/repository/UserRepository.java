package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from usuarios where (documento = :identification)", nativeQuery = true)
    User findByDocumento(String identification);

    @Query(value = "select * from usuarios where (documento = :identification) or (correo_electronico = :identification) or (usuario_app = :identification)", nativeQuery = true)
    User findByDocumento(@Param("identification") String identification,@Param("correo") String correo, @Param("user") String user);


    @Query(value = "select * from usuarios where (usuario_app = :user) and (password_app = :password)", nativeQuery = true)
    User findByUserAndPassword(@Param("user") String user);

    @Query(value = "select * from usuarios where (usuario_app = :user)", nativeQuery = true)
    User findByUsuarioApp(@Param("user") String user);
}
