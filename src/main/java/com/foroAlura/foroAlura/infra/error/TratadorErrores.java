package com.foroAlura.foroAlura.infra.error;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity errorNoEncontrado(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity datoNulo(MethodArgumentNotValidException e){
        var errores=e.getFieldErrors().stream().map(DatosError::new).toList();
        return ResponseEntity.ok(errores);
    }
}
