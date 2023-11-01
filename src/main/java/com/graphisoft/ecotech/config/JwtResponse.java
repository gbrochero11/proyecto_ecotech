package com.graphisoft.ecotech.config;

import javax.persistence.Column;
import java.io.Serializable;
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final Long id;
    private final String documento;
    private final Long tipousuario;
    private final String nombre;
    public JwtResponse(String jwttoken, Long id, String documento, Long tipousuario, String nombre) {
        this.jwttoken = jwttoken;
        this.id = id;
        this.documento = documento;
        this.tipousuario = tipousuario;
        this.nombre = nombre;
    }
    public String getToken() {
        return this.jwttoken;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getTipousuario() {
        return tipousuario;
    }

    public String getNombre() {
        return nombre;
    }
}
