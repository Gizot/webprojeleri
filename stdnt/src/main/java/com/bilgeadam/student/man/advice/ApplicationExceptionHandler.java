package com.bilgeadam.student.man.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bilgeadam.student.man.exception.StudentNotFoundException;


/**
 * 
 * @author izzet.bozoglu
 *	arayüzden gönderilen verilerde StudentDTO nesnesi field ları
 *için tanımlanan validation lara uygunsuz veri olması halinde
 * uygunsuzluğa özel hata mesajları göstermek için yazıldı
 */
@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalidArgument(ConstraintViolationException ex){
		
		Map<String, String> errMap = new HashMap<>();
		
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errMap.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		
		return errMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(StudentNotFoundException.class)
	public Map<String, String> handleInvalidArgument(StudentNotFoundException ex){
		
		Map<String, String> errMap = new HashMap<>();
		
		errMap.put("Hata : ", ex.getLocalizedMessage());
		
		return errMap;
	}

}