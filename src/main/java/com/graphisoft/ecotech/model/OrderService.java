package com.graphisoft.ecotech.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "solicitud_servicios")
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documento_usuario;
    private Long codigo_estado;
    private String direccion;
    private Long toneladas;
    private String fecha_solicitud;
    private String ciudad_origen;
    private Long telefono;
    private String documento_empresa;
}
