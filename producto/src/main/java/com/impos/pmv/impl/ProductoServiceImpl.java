package com.impos.pmv.impl;

import com.impos.pmv.exception.ProductoNoEncontradaException;
import com.impos.pmv.exception.UsuarioNoEncontradaException;
import com.impos.pmv.model.dto.CategoriaDto;
import com.impos.pmv.model.dto.ProductosDto;
import com.impos.pmv.model.entity.TblCategoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */








import com.impos.pmv.model.entity.TblProductos;
import com.impos.pmv.repository.ProductoServiceRepository;
import com.impos.pmv.service.ProductoService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jwmoreno
 */
@Service
public class ProductoServiceImpl implements ProductoService{
    
      private final ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    ProductoServiceRepository productoServiceRepository;

    @Override
    public List<TblProductos> findAll() {
 
        return productoServiceRepository.findAll().stream().map(pro ->pro).collect(Collectors.toList());
   
    }

	@Override
	public ProductosDto save(ProductosDto productosDto) {
		
return modelMapper.map(productoServiceRepository.save(modelMapper.map(productosDto, TblProductos.class)),
		ProductosDto.class);
	}

	@Override
	public ProductosDto update(ProductosDto productosDto) {
		productoServiceRepository.findById(productosDto.getId())
		.orElseThrow(() -> new ProductoNoEncontradaException("El Producto no se encontro"));
return modelMapper.map(productoServiceRepository.save(modelMapper.map(productosDto, TblProductos.class)),
		ProductosDto.class);
	}


    
    
}
