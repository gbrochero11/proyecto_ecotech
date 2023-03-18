package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAppDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private Long id_empresa;
    private Long id_tipo_usuario;
    private String documento;
    private String nombres;
    private String apellidos;
    private String usuarioapp;
    private String contrasenaapp;

    private Long idService;
    private String ciudad_origen;
    private String direccion;
    private Long toneladas;
    private String fecha_solicitud;
    private Long telefono;
    private String nombre;
    private Long codigo_rut;
}
