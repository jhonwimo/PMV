package com.impos.pmv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UsuarioIncorrectoEncontradaException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UsuarioIncorrectoEncontradaException(String message) {
        super(message);
    }
    public UsuarioIncorrectoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }
}
