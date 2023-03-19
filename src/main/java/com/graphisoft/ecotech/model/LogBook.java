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
@Table(name = "bitacora_servicio")
public class LogBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_solicitud;
    private String descripcion;
    private String fecha_registro;
    private Long estado_servicio;
    private Long toneladas;
    private String tipo_desecho;
}
