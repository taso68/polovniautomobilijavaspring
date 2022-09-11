package com.taso.polovniautomobili.exceptions;

import com.taso.polovniautomobili.exceptions.custom.AlreadyExistException;
import com.taso.polovniautomobili.exceptions.custom.BadRequestException;
import com.taso.polovniautomobili.exceptions.custom.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String, Object> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
//        errorMap.put("statusMsg", HttpStatus.NOT_FOUND.getReasonPhrase());
//        errorMap.put("status", 404);
        return errorMap;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> handleNotFoundException(NotFoundException ex){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
//        errorMap.put("statusMsg", HttpStatus.NOT_FOUND.getReasonPhrase());
//        errorMap.put("status", 404);
        return errorMap;
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyExistException.class)
    public Map<String, Object> AlreadyExistException(AlreadyExistException ex){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Map<String, Object> BadRequestException(BadRequestException ex){
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }

}
