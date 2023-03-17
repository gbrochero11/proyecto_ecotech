package com.graphisoft.ecotech.repository;

import com.graphisoft.ecotech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from usuarios where (documento = :identification)", nativeQuery = true)
    User findByDocumento(String identification);


    @Query(value = "select * from usuarios where (usuario_app = :user) and (password_app = :password)", nativeQuery = true)
    User findByUserAndPassword(@Param("user") String user, @Param("password") String password);
}
