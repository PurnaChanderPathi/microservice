package com.ppc.user.servcie.UserService.exceptions;

import com.ppc.user.servcie.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(ResoruceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResoruceNotFoundException ex)
    {
        String message = ex.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return new  ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
