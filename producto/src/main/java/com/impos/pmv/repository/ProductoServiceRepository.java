package com.impos.pmv.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





import com.impos.pmv.model.entity.TblProductos;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jwmoreno
 */
@Repository
public interface ProductoServiceRepository  extends JpaRepository<TblProductos, Long> {
    
    
     
        
  
   
}
