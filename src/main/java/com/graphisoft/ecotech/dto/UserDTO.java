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
    private String tipoUsuario;
    private String nombre;
    private String razon_social;
    private Long codigoRut;
    private String direccion;
    private String representante;
    private Long telefono;
    private String correo_electronico;
    private String user;
    private String password;
}
