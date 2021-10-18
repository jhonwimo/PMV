package com.impos.pmv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsuarioNoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsuarioNoEncontradaException(String message) {
        super(message);
    }
    public UsuarioNoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
