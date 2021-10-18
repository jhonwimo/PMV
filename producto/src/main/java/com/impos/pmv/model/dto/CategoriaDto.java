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
public class CategoriaDto {

    private Long idCategoria;
    @NotNull(message="El campo debe ser enviado")
    private String nombre;
    @NotNull(message="El campo debe ser enviado")
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
