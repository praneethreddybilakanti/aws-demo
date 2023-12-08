package com.ecommerce.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(NoSuchElementException.class)
    public ProblemDetail noSuchElementException(NoSuchElementException ex){
        ProblemDetail problemDetail =ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setProperty("errors",List.of(ex.getMessage()));
        problemDetail.setProperty("timestamp", LocalDateTime.now());
        problemDetail.setTitle(ex.getMessage());
    problemDetail.setStatus(HttpStatus.NOT_FOUND);

    return problemDetail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationError(MethodArgumentNotValidException ex, WebRequest webRequest) {
        ProblemDetail problemDetail =ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        problemDetail.setProperty("errors",errors);
        problemDetail.setProperty("timestamp",LocalDateTime.now());
        problemDetail.setTitle(ex.getStatusCode().toString());
        //problemDetail.setProperty("getAllErrors",ex.getAllErrors());

        return problemDetail;
    }


    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ProblemDetail sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex,WebRequest webRequest) {
        ProblemDetail problemDetail =ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

      problemDetail.setProperty("errors",List.of(ex.getMessage()));
      problemDetail.setProperty("status_code",ex.getErrorCode());
        problemDetail.setProperty("timestamp",LocalDateTime.now());
        //problemDetail.setProperty("getAllErrors",ex.getAllErrors());
problemDetail.setStatus(HttpStatus.BAD_REQUEST);
        return problemDetail;
    }
    @ExceptionHandler({JsonEOFException.class, JsonParseException.class})
    public ProblemDetail jsonEOFException( JsonParseException ex,WebRequest webRequest) {
        ProblemDetail problemDetail =ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setProperty("errors",List.of(ex.getMessage()));
        problemDetail.setProperty("timestamp",LocalDateTime.now());
        //problemDetail.setProperty("getAllErrors",ex.getAllErrors());
        problemDetail.setStatus(HttpStatus.BAD_REQUEST);
        return problemDetail;
    }
}
