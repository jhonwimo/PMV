package com.impos.pmv.impl;

import com.impos.pmv.exception.CategoriaNoEncontradaException;
import com.impos.pmv.exception.ProductoNoEncontradaException;

import com.impos.pmv.model.dto.ProductosDto;
import com.impos.pmv.model.entity.TblCategorias;
import com.impos.pmv.model.entity.TblEstados;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.impos.pmv.model.entity.TblProductos;

import com.impos.pmv.repository.CategoriaServiceRepository;
import com.impos.pmv.repository.ProductoServiceRepository;
import com.impos.pmv.repository.EstadoServiceRepository;
import com.impos.pmv.service.ProductoService;
import com.impos.pmv.util.Msm;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author jwmoreno
 */
@Service
public class ProductoServiceImpl implements ProductoService {

	Msm msm=new Msm();

	@Autowired
	ProductoServiceRepository productoServiceRepository;
	@Autowired
	CategoriaServiceRepository categoriaServiceRepository;

	@Autowired
	EstadoServiceRepository estadoServiceRepository;

	@Override
	public List<TblProductos> findAll() {

		return productoServiceRepository.findAll();

	}

	@Override
	public ProductosDto save(ProductosDto productosDto) {

		categoriaServiceRepository.findById(productosDto.getIdCategoria())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.CATEGORIA));

		estadoServiceRepository.findById(productosDto.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.ESTADO));

		TblProductos producto = new TblProductos();
		TblCategorias categoria = new TblCategorias();
		TblEstados estado = new TblEstados();
		estado.setIdEstado(productosDto.getIdEstado());
		categoria.setIdCategoria(productosDto.getIdCategoria());
		producto.setNombre(productosDto.getNombre());
		producto.setPrecio(productosDto.getPrecio());
		producto.setTag(productosDto.getTag());
		producto.setCosto(productosDto.getCosto());
		producto.setFechaCreacion(new Date());
		producto.setFechaActualizacion(new Date());
		producto.setIdEstado(estado);
		productoServiceRepository.save(producto);
		return productosDto;
	}

	@Override
	public ProductosDto update(ProductosDto productosDto) {
		TblProductos product = productoServiceRepository.findById(productosDto.getId())
				.orElseThrow(() -> new ProductoNoEncontradaException(msm.PRODUCTO));

		categoriaServiceRepository.findById(productosDto.getIdCategoria())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.CATEGORIA));

		estadoServiceRepository.findById(productosDto.getIdEstado())
				.orElseThrow(() -> new CategoriaNoEncontradaException(msm.ESTADO));

		TblEstados estado = new TblEstados();
		TblCategorias categoria = new TblCategorias();
		estado.setIdEstado(productosDto.getIdEstado());
		categoria.setIdCategoria(productosDto.getIdCategoria());
		product.setIdEstado(estado);
		product.setFechaActualizacion(new Date());

		product.setTag(productosDto.getTag() == null ? productosDto.getTag() : product.getTag());
		product.setNombre(productosDto.getNombre() == null ? productosDto.getNombre() : product.getNombre());
		product.setPrecio(productosDto.getPrecio() == null ? productosDto.getPrecio() : product.getPrecio());
		product.setCosto(productosDto.getCosto() == null ? productosDto.getCosto() : product.getCosto());

		productoServiceRepository.save(product);

		return productosDto;
	}

}
