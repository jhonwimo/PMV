package com.impos.pmv.service;




import com.impos.pmv.model.dto.UsuarioDto;
import com.impos.pmv.model.entity.TblUsuarios;

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
public interface UsuarioService {
    

    public List<TblUsuarios> findAll();
    
     public UsuarioDto save(UsuarioDto usuarios);
     
         public UsuarioDto update(UsuarioDto usuarios);
    
     public TblUsuarios findByNombreUsuario(String nombre);
    
}
