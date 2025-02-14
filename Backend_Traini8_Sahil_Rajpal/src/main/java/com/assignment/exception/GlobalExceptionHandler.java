package com.assignment.exception;

import com.assignment.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( value = TrainingCenterResponseException.class)
    public ResponseEntity<ExceptionResponse> handleTrainingResponseException(TrainingCenterResponseException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PageResponseException.class)
    public ResponseEntity<ExceptionResponse> handlePageResponseException(PageResponseException exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleInvalidArgument(MethodArgumentNotValidException exception){
        HashMap<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error ->
            errorMap.put(error.getField(), error.getDefaultMessage()));
        return new  ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
}
