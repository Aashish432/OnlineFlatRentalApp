package com.cg.flatrental.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TenantNotFoundException extends RuntimeException{
	private String message;
}
