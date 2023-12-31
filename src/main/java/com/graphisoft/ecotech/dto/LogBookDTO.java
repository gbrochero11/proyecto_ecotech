package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogBookDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private Long id_solicitud;
    private String descripcion;
    private String fecha_registro;
    private Long estado_servicio;
    private Long toneladas;
    private String tipo_desecho;
    private Long id_recurso;
    private String nombre_servicio;
    private String empresa_entrega;
    private String empresa_recibe;
    private String observaciones;
    private String cantidad;

}
