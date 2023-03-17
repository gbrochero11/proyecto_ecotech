package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderServiceDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private String documento_usuario;
    private Long codigo_estado;
    private String direccion;
    private Long toneladas;
    private String fecha_solicitud;
    private String ciudad_origen;
    private String nombre_horeca;
    private Long telefono;
    private String documento_empresa;
}
