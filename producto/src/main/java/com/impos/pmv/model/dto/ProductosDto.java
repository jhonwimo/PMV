package com.impos.pmv.model.dto;



import javax.validation.constraints.NotNull;

public class ProductosDto {

	private Long id;

	@NotNull(message = "El campo debe ser enviado")
	private String nombre;
	@NotNull(message = "El campo debe ser enviado")
	private Long idCategoria;
	@NotNull(message = "El campo debe ser enviado")
	private Long costo;
	@NotNull(message = "El campo debe ser enviado")
	private Long precio;
	@NotNull(message = "El campo debe ser enviado")
	private String tag;

	@NotNull(message = "El campo debe ser enviado")
	private Long idEstado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getCosto() {
		return costo;
	}

	public void setCosto(Long costo) {
		this.costo = costo;
	}

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

}
