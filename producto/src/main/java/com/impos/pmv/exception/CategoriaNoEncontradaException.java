package com.impos.pmv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CategoriaNoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CategoriaNoEncontradaException(String message) {
        super(message);
    }
    public CategoriaNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
