package com.impos.pmv.impl;

import com.impos.pmv.exception.CategoriaNoEncontradaException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.impos.pmv.model.dto.CategoriaDto;

import com.impos.pmv.model.entity.TblCategorias;
import com.impos.pmv.model.entity.TblEstados;
import com.impos.pmv.repository.CategoriaServiceRepository;
import com.impos.pmv.repository.EstadoServiceRepository;
import com.impos.pmv.service.CategoriaService;
import com.impos.pmv.util.Msm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author jwmoreno
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

	

	@Autowired
	CategoriaServiceRepository categoriaServiceRepository;

	@Autowired
	EstadoServiceRepository estadoServiceRepository;
	
	Msm msm=new Msm();

	@Override
	public List<TblCategorias> findAll() {
		return categoriaServiceRepository.findAll();

	}

	@Override
	public CategoriaDto save(CategoriaDto categoriaDto) {
		estadoServiceRepository.findById(categoriaDto.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.ESTADO));
		TblCategorias categoria = new TblCategorias();
		TblEstados estado = new TblEstados();
		estado.setIdEstado(categoriaDto.getIdEstado());
		categoria.setFechaCreacion(new Date());
		categoria.setFechaActualizacion(new Date());
		categoria.setNombre(categoriaDto.getNombre());
		categoria.setIdEstado(estado);
		categoriaServiceRepository.save(categoria);
		return categoriaDto;
	}

	@Override
	public CategoriaDto update(CategoriaDto categoriaDto) {
		categoriaServiceRepository.findById(categoriaDto.getIdCategoria())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.CATEGORIA));

		estadoServiceRepository.findById(categoriaDto.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.ESTADO));

		TblCategorias categoria = new TblCategorias();
		TblEstados estado = new TblEstados();
		estado.setIdEstado(categoriaDto.getIdEstado());
		categoria.setFechaActualizacion(new Date());
		categoria.setNombre(categoriaDto.getNombre());
		categoria.setIdEstado(estado);
		categoriaServiceRepository.save(categoria);

		return categoriaDto;

	}

}
