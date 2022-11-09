package com.cg.flatrental.app.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserValidationException extends RuntimeException{
	
	private String message;
	

}
