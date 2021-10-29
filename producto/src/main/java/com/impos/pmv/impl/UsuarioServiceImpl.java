package com.impos.pmv.impl;


import com.impos.pmv.exception.UsuarioNoEncontradaException;
import com.impos.pmv.model.dto.UsuarioDto;
import com.impos.pmv.model.entity.TblUsuarios;
import com.impos.pmv.repository.UsuarioServiceRepository;

import com.impos.pmv.service.UsuarioService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/**
 *
 * @author jwmoreno
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UsuarioServiceRepository usuarioServiceRepository;

    @Override
    public List<TblUsuarios> findAll() {

        return usuarioServiceRepository.finProdcutos();

    }







	@Override
	public UsuarioDto update(UsuarioDto usuarios) {
		 usuarioServiceRepository.findById(Long.parseLong(usuarios.getId())).orElseThrow(() -> new UsuarioNoEncontradaException("El usuario no se encontro"));
	       
	        return modelMapper.map(usuarioServiceRepository.save(modelMapper.map(usuarios, TblUsuarios.class)), UsuarioDto.class);

	}






	@Override
	public UsuarioDto save(UsuarioDto usuarios) {
		return modelMapper.map(usuarioServiceRepository.save(modelMapper.map(usuarios, TblUsuarios.class)), UsuarioDto.class);
	}







	@Override
	public TblUsuarios findByNombreUsuarioAndClave(String nombre, String password) {
		return usuarioServiceRepository.findByNombreUsuarioAndClave(nombre,password);
	}
	
	
	

}
