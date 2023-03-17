package com.graphisoft.ecotech.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseModel {

    private Timestamp timestamp;
    private Object data;
    private int responseCode;
    private String status;

    public ResponseModel(Timestamp timestamp, Object data, int respondeCode, String status) {
        super();
        this.timestamp = timestamp;
        this.data = data;
        this.responseCode = respondeCode;
        this.status = status;
    }

    public static ResponseEntity<?> success(Object data, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("time", new Date().toString());
        response.put("status", status.value());
        response.put("data", data);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<?> error(Exception ex, HttpStatus status, String path) {
        Map<String, Object> response = new HashMap<>();
        response.put("error", ex.getClass().getSimpleName());
        response.put("message", ex.getMessage());
        response.put("status", status.value());
        response.put("path", path);
        response.put("time", new Date().toString());
        return new ResponseEntity<>(response, status);
    }



}
