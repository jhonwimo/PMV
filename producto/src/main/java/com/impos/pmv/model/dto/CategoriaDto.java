/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impos.pmv.model.dto;



/**
 *
 * @author jwmoreno
 */
public class CategoriaDto {

    private Long idCategoria;
   
    private String nombre;
   
    private Long IdEstado;
   


    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public Long getIdEstado() {
		return IdEstado;
	}

	public void setIdEstado(Long idEstado) {
		IdEstado = idEstado;
	}

    


    

}
