package com.impos.pmv.model.dto;

import java.util.Date;



public class ProductosDto {
	
	 private Long id;
	 
	    private String nombre;
	   
	    private String idCategoria;
	    
	    private String costo;
	   
	    private String precio;
	   
	    private String listatag;
	    
	    private Date fechaCreacion;
	    
	    private Date fechaActualizacion;
	   
	    private Character idEstado;

	

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

		public String getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(String idCategoria) {
			this.idCategoria = idCategoria;
		}

		public String getCosto() {
			return costo;
		}

		public void setCosto(String costo) {
			this.costo = costo;
		}

		public String getPrecio() {
			return precio;
		}

		public void setPrecio(String precio) {
			this.precio = precio;
		}

		public String getListatag() {
			return listatag;
		}

		public void setListatag(String listatag) {
			this.listatag = listatag;
		}

		public Date getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public Date getFechaActualizacion() {
			return fechaActualizacion;
		}

		public void setFechaActualizacion(Date fechaActualizacion) {
			this.fechaActualizacion = fechaActualizacion;
		}

		public Character getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(Character idEstado) {
			this.idEstado = idEstado;
		}

		
	    
}
