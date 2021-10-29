package com.impos.pmv.impl;

import com.impos.pmv.exception.CategoriaNoEncontradaException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.impos.pmv.model.dto.CategoriaDto;

import com.impos.pmv.model.entity.TblCategoria;

import com.impos.pmv.repository.CategoriaServiceRepository;

import com.impos.pmv.service.CategoriaService;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jwmoreno
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	CategoriaServiceRepository categoriaServiceRepository;

	@Override
	public List<TblCategoria> findAll() {
		return categoriaServiceRepository.findAll();

	}

	@Override
	public CategoriaDto save(CategoriaDto categoriaDto) {

		return modelMapper.map(
				categoriaServiceRepository.saveAndFlush(modelMapper.map(categoriaDto, TblCategoria.class)),
				CategoriaDto.class);
	}

	@Override
	public CategoriaDto update(CategoriaDto categoriaDto) {
		categoriaServiceRepository.findById(categoriaDto.getIdCategoria())
				.orElseThrow(() -> new CategoriaNoEncontradaException("Categoria no se encontro"));
		return modelMapper.map(categoriaServiceRepository.save(modelMapper.map(categoriaDto, TblCategoria.class)),
				CategoriaDto.class);

	}

}
