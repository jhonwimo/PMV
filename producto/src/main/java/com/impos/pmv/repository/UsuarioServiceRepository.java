package com.impos.pmv.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */







import com.impos.pmv.model.entity.TblUsuarios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

/**
 *
 * @author jwmoreno
 */
@Repository
public interface UsuarioServiceRepository  extends JpaRepository<TblUsuarios, Long> {
    
    
      @Query(value = "SELECT u FROM TblUsuarios u  ")
    public List<TblUsuarios> finProdcutos ();
    
    
       @Query(value = "SELECT u FROM TblUsuarios u where u.nombreUsuario= :usu and  u.clave= :pass")
    public TblUsuarios findByNombreUsuarioAndClave (@Param("usu") String usu,@Param("pass") String clave);
    
    
  
        
  
   
}
