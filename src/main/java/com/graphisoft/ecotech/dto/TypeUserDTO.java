package com.graphisoft.ecotech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeUserDTO {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Long id;
    private String nombre;
}
