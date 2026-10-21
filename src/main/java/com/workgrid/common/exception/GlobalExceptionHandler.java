package com.workgrid.common.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {

		String cleanMessage = e.getConstraintViolations().stream().map(violation -> {
			String fullPath = violation.getPropertyPath().toString();
			String paramName = fullPath.contains(".") ? fullPath.substring(fullPath.lastIndexOf('.') + 1) : fullPath;
			return paramName + ": " + violation.getMessage();
		}).collect(Collectors.joining(", "));

		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), cleanMessage,
				ErrorCodeValues.VALIDATION_FAILED);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), e.getMessage(),
				ErrorCodeValues.RESOURCE_NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		String cleanMessage = e.getBindingResult().getAllErrors().stream().map(error -> {
			if (error instanceof FieldError fieldError) {
				return fieldError.getField() + ": " + fieldError.getDefaultMessage();
			}
			return error.getDefaultMessage();
		}).collect(Collectors.joining(", "));

		ErrorResponse response = new ErrorResponse(LocalDateTime.now(), cleanMessage,
				ErrorCodeValues.VALIDATION_FAILED);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
