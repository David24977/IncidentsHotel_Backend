package com.David.IncidentsHotelBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===== 404 NOT FOUND =====
    @ExceptionHandler({
            ResourceNotFoundException.class
            })
    public ApiErrorResponse handleNotFound(RuntimeException ex) {
        return new ApiErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
    }

   

    // ===== 400 BAD REQUEST =====
    @ExceptionHandler(BadRequestException.class)
    public ApiErrorResponse handleBadRequest(BadRequestException ex) {
        return new ApiErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }
    

    // ===== VALIDATION ERRORS =====
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiErrorResponse handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        return new ApiErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value()
        );
    }

    // ===== FALLBACK (500) =====
	/*
	 * @ExceptionHandler(Exception.class) public ApiErrorResponse
	 * handleGeneric(Exception ex) { return new ApiErrorResponse(
	 * "Unexpected server error", HttpStatus.INTERNAL_SERVER_ERROR.value() ); }
	 */
}
