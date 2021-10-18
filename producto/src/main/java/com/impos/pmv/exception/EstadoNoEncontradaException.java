package com.impos.pmv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EstadoNoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public EstadoNoEncontradaException(String message) {
        super(message);
    }
    public EstadoNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
