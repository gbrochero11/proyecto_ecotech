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
    @Column(name="documento")
    private Long documento;
    @Column(name="tipousuario")
    private Long tipoUsuario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="razon_social")
    private String razon_social;
    @Column(name="codigo_rut")
    private Long codigoRut;
    @Column(name="direccion")
    private String direccion;
    @Column(name="representante")
    private String representante;
    @Column(name="telefono")
    private Long telefono;
    @Column(name="correo_electronico")
    private String correoElectronico;
    @Column(name="usuario_app")
    private String usuarioApp;
    @Column(name="password_app")
    private String passwordApp;
    @Column(name="ciudad")
    private String ciudad;
    @Column(name="tipo_documento")
    private Long tipo_documento;
}
