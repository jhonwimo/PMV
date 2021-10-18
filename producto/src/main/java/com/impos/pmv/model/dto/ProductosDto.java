package com.impos.pmv.model.dto;

import java.util.Date;



public class ProductosDto {
	
	 private Long id;
	 
	    private String nombre;
	   
	    private Long idCategoria;
	    
	    private Long costo;
	   
	    private Long precio;
	   
	    private String tag;
	    
	    
	   
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
