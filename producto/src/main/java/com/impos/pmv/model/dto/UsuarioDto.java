/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impos.pmv.model.dto;

import javax.validation.constraints.NotNull;

/**
 *
 * @author jwmoreno
 */
public class UsuarioDto {

	private Long id;
	@NotNull(message = "El campo debe ser enviado")
	private String nombreCompleto;
	@NotNull(message = "El campo debe ser enviado")
	private String nombreUsuario;
	@NotNull(message = "El campo debe ser enviado")
	private String clave;
	@NotNull(message = "El campo debe ser enviado")
	private Long nivelAcceso;
	@NotNull(message = "El campo debe ser enviado")
	private Long idEstado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Long getNivelAcceso() {
		return nivelAcceso;
	}

	public void setNivelAcceso(Long nivelAcceso) {
		this.nivelAcceso = nivelAcceso;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

}
