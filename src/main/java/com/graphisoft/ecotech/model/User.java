package com.graphisoft.ecotech.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long documento;
    private Long tipousuario;
    private String nombre;
    private String razon_social;
    private Long codigo_rut;
    private String direccion;
    private String representante;
    private Long telefono;
    private String correo_electronico;
    private String usuario_app;
    private String password_app;
    private String ciudad;
}
