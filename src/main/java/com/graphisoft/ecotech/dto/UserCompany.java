package com.graphisoft.ecotech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCompany {

    private Long documento;
    private String nombre;
    private String direccion;
    private String representante;
    private Long telefono;
    private String correoElectronico;
    private String ciudad;
}
