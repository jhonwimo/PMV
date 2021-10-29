package com.impos.pmv.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */






import com.impos.pmv.model.entity.TblCategoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jwmoreno
 */
@Repository
public interface CategoriaServiceRepository  extends JpaRepository<TblCategoria, Long> {
    
    
      @Query(value = "SELECT u FROM TblCategoria u  ")
    public List<TblCategoria> finCategoria ();
        
  
   
}
