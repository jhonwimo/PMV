package com.impos.pmv.impl;

import com.impos.pmv.exception.CategoriaNoEncontradaException;
import com.impos.pmv.exception.UsuarioNoEncontradaException;
import com.impos.pmv.model.dto.UsuarioDto;
import com.impos.pmv.model.entity.TblEstados;
import com.impos.pmv.model.entity.TblRoles;
import com.impos.pmv.model.entity.TblUsuarios;
import com.impos.pmv.repository.EstadoServiceRepository;
import com.impos.pmv.repository.RolServiceRepository;
import com.impos.pmv.repository.UsuarioServiceRepository;

import com.impos.pmv.service.UsuarioService;
import com.impos.pmv.util.Msm;

import java.util.Date;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	Msm msm=new Msm();

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UsuarioServiceRepository usuarioServiceRepository;
	@Autowired
	RolServiceRepository rolServiceRepository;
	
	@Autowired
	EstadoServiceRepository estadoServiceRepository;

	@Override
	public List<TblUsuarios> findAll() {

		return usuarioServiceRepository.finProdcutos();

	}

	@Override
	public UsuarioDto update(UsuarioDto usuarios) {
		usuarioServiceRepository.findById(usuarios.getId())
				.orElseThrow(() -> new UsuarioNoEncontradaException(msm.USUARIO));

		rolServiceRepository.findById(usuarios.getNivelAcceso()).orElseThrow(
				() -> new UsuarioNoEncontradaException(msm.ROL));

	    estadoServiceRepository.findById(usuarios.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.ESTADO));

		TblUsuarios usuario = modelMapper.map(usuarios, TblUsuarios.class);
		TblEstados estado = new TblEstados();
		estado.setIdEstado(usuarios.getIdEstado());
		usuario.setIdEstado(estado);
		usuarioServiceRepository.save(usuario);
		return usuarios;

	}

	@Override
	public UsuarioDto save(UsuarioDto usuarios) {

		rolServiceRepository.findById(usuarios.getNivelAcceso()).orElseThrow(
				() -> new UsuarioNoEncontradaException(msm.ROL));



		estadoServiceRepository.findById(usuarios.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(	msm.ESTADO));

		TblUsuarios usario = new TblUsuarios();
		TblEstados estado = new TblEstados();
		TblRoles rol = new TblRoles();
		rol.setId(usuarios.getNivelAcceso());
		estado.setIdEstado(usuarios.getIdEstado());
		usario.setClave(bCryptPasswordEncoder.encode(usuarios.getClave()));
		usario.setNombreCompleto(usuarios.getNombreCompleto());
		usario.setNombreUsuario(usuarios.getNombreUsuario());
		usario.setNivelAcceso(rol);
		usario.setIdEstado(estado);
		usario.setFechaCreacion(new Date());
		usario.setFechaUltimoIngreso(new Date());
		usuarioServiceRepository.save(usario);
		return usuarios;

	}

	@Override
	public TblUsuarios findByNombreUsuario(String nombre) {
		return usuarioServiceRepository.findByNombreUsuario(nombre);
	}

}
