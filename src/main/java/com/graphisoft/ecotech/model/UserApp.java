package com.graphisoft.ecotech.model;

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
@Table(name = "recursos_empresas")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_empresa;
    private Long id_tipo_usuario;
    private String documento;
    private String nombres;
    private String apellidos;
    private String usuarioapp;
    private String contrasenaapp;
}
