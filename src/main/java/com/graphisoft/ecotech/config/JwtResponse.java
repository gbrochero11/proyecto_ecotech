package com.graphisoft.ecotech.config;

import javax.persistence.Column;
import java.io.Serializable;
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final Long id;
    private final Long documento;
    private final Long tipoUsuario;
    private final String nombre;
    public JwtResponse(String jwttoken, Long id, Long documento, Long tipoUsuario, String nombre) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.documento = documento;
        this.tipoUsuario = tipoUsuario;
        this.nombre = nombre;
    }
    public String getToken() {
        return this.jwttoken;
    }

    public Long getId() {
        return id;
    }

    public Long getDocumento() {
        return documento;
    }

    public Long getTipoUsuario() {
        return tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }
}
