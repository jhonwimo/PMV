package com.impos.pmv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductoNoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ProductoNoEncontradaException(String message) {
        super(message);
    }
    public ProductoNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
