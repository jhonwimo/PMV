package com.impos.pmv.service;



import com.impos.pmv.model.dto.CategoriaDto;
import com.impos.pmv.model.entity.TblCategorias;

import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author jwmoreno
 */
public interface CategoriaService {
    

    public List<TblCategorias> findAll();
    
    public CategoriaDto save (CategoriaDto categoriaDto);
    
    public CategoriaDto update (CategoriaDto categoriaDto);
    
}
