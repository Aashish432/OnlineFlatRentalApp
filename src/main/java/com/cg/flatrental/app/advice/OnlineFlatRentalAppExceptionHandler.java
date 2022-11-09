package com.cg.flatrental.app.advice;

import java.util.LinkedHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.flatrental.app.exception.FlatBookingNotFoundException;
import com.cg.flatrental.app.exception.FlatNotFoundException;
import com.cg.flatrental.app.exception.LandlordNotFoundException;
import com.cg.flatrental.app.exception.TenantNotFoundException;
import com.cg.flatrental.app.exception.UserNotFoundException;
import com.cg.flatrental.app.exception.UserValidationException;


@RestControllerAdvice
public class OnlineFlatRentalAppExceptionHandler {
	
	/*
	 Exception: MethodArgumentNotValidException
	 This is the global exception handler of custom MethodArgumentNotValidException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as field name and error message string with response status 400 [Bad Request]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public LinkedHashMap<String, String> handleBardRequest(MethodArgumentNotValidException me){
		
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();		
		
		me.getFieldErrors().stream().forEach(fieldError -> {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
				
		return errors;
	}

	/*
	 Exception: FlatNotFoundException
	 This is the global exception handler of custom FlatNotFoundException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as flatId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FlatNotFoundException.class)
	public LinkedHashMap<String, String> handleFlatNotFound(FlatNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("flatId",e.getMessage());
		return errors;
	}
	
	/*
	 Exception: UserNotFoundException
	 This is the global exception handler of custom UserNotFoundException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as userId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public LinkedHashMap<String, String> handleUserNotFound(UserNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("userId",e.getMessage());
		return errors;
	}
	
	/*
	 Exception: UserValidationException
	 This is the global exception handler of custom UserValidationException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as userId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserValidationException.class)
	public LinkedHashMap<String, String> handleUserValidation(UserValidationException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("userId",e.getMessage());
		return errors;
	}
	
	/*
	 Exception: LandlordNotFoundException
	 This is the global exception handler of custom LandlordNotFoundException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as landlordId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(LandlordNotFoundException.class)
	public LinkedHashMap<String, String> handlerLandlordNotFound(LandlordNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("landlordId",e.getMessage());
		return errors;
	}
	
	/*
	 Exception: FlatBookingNotFoundException
	 This is the global exception handler of custom FlatBookingNotFoundException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as FlatBookingId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FlatBookingNotFoundException.class)
	public LinkedHashMap<String, String> handleFlatBookingNotFound(FlatBookingNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("FlatBookingId",e.getMessage());
		return errors;
	}
	
	/*
	 Exception: TenantNotFoundException
	 This is the global exception handler of custom TenantNotFoundException exception
	 and it is handled by using annotation @ExceptionHandler
	 and it is returning a map of key value pair as TenantId and error message string with response status 404 [not found]
	 by using @ResponseStatus annotation
	 */
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(TenantNotFoundException.class)
	public LinkedHashMap<String, String> handleTenantNotFound(TenantNotFoundException e) {
		LinkedHashMap<String, String> errors = new LinkedHashMap<String, String>();	
		errors.put("TenantId",e.getMessage());
		return errors;
	}
	
}
