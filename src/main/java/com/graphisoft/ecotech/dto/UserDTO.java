package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private String documento;
    private Long tipoUsuario;
    private String nombre;
    private String razon_social;
    private Long codigoRut;
    private String direccion;
    private String representante;
    private Long telefono;
    private String correoElectronico;
    private String usuarioApp;
    private String passwordApp;
    private String ciudad;
    private Long tipo_documento;
}
