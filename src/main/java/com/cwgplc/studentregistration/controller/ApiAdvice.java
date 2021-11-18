package com.cwgplc.studentregistration.controller;

import com.cwgplc.studentregistration.dto.Error;
import com.cwgplc.studentregistration.dto.ErrorResponse;
import com.cwgplc.studentregistration.dto.FacultyResponse;
import com.cwgplc.studentregistration.dto.Response;
import com.cwgplc.studentregistration.exception.InvalidRequestException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import net.bytebuddy.pool.TypePool;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = RestController.class)
public class ApiAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();

        e.getFieldErrors().forEach(fieldError -> {
            errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));});

     return ResponseEntity.badRequest().body( new ErrorResponse( ""+HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),errors));
     }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        Response response = new Response("400", e.getLocalizedMessage());
        if (e.getCause() != null)
        {
            String message = e.getCause().getMessage();
            if (e.getCause() instanceof JsonMappingException)
            {
                String[] arr = message.split("\\(");
                if (arr.length > 0) {
                    String temp = arr[0];
                    String[] arr2 = message.split("\\[");
                    if (arr2.length > 1) {
                        message = temp + " (field: [" + arr2[1];
                    } else {
                        message = temp;
                    }
                }
            }
            if (e.getCause() instanceof JsonParseException) {
                String[] arr = message.split("at");
                if (arr.length > 0) {
                    String temp = arr[0];
                    JsonParseException jpe = (JsonParseException) e.getCause();
                    message = temp + " [line: " + jpe.getLocation().getLineNr() + ", column: " + jpe.getLocation().getColumnNr() + "]";
                }
            }
            response = new Response("400", message);

        }
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Response> handleInvalidRequestException (InvalidRequestException e)
    {
        Response response = new Response(HttpStatus.BAD_REQUEST.toString(), e.getLocalizedMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
