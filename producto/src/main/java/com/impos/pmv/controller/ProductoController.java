package com.impos.pmv.controller;

import com.impos.pmv.model.dto.CategoriaDto;
import com.impos.pmv.model.dto.ProductosDto;
import com.impos.pmv.model.entity.TblProductos;
import com.impos.pmv.service.ProductoService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@PostMapping("/producto")
	public ResponseEntity<?> Post(@Valid @RequestBody ProductosDto productosDto) {
		return ResponseEntity.ok(productoService.save(productosDto));
	}

	@GetMapping("/producto")
	public ResponseEntity<?> Get() {
		return ResponseEntity.ok(productoService.findAll());
	}

	@PutMapping("/producto")
	public ResponseEntity<?> Get(@Valid @RequestBody ProductosDto productosDto) {
		return ResponseEntity.ok(productoService.update(productosDto));
	}

}
