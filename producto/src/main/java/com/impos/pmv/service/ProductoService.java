package com.impos.pmv.service;




import com.impos.pmv.model.dto.ProductosDto;
import com.impos.pmv.model.entity.TblProductos;
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
public interface ProductoService {
    

    public List<TblProductos> findAll();
    
   public ProductosDto save (ProductosDto productosDto);
    
    public ProductosDto update (ProductosDto productosDto);
    
    
}
