package com.cg.flatrental.app.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlatNotFoundException extends RuntimeException {
	
	private String message;
	
}
