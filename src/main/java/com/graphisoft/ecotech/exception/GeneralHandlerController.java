package com.graphisoft.ecotech.exception;

import com.graphisoft.ecotech.utils.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GeneralHandlerController extends ExceptionStatus {

    public GeneralHandlerController() {
        super();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> missingServletRequestParameterException(Exception ex, HttpServletRequest request) {
        String name = ex.getClass().getSimpleName();
        int code = statusCode.get(name) != null ? statusCode.get(name) : 500;
        return ResponseModel.error(ex, HttpStatus.valueOf(code), request.getServletPath());
    }
}
