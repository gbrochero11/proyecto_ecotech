package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private Long documento;
    private Long telefono;
    private Long codigo_rut;
    private Long tipoUsuario;
    private String nombre;
    private String razon_social;
    private String direccion;
    private String representante;
    private String correo_electronico;
    private String usuario_app;
    private String password_app;
    private String ciudad;
}
