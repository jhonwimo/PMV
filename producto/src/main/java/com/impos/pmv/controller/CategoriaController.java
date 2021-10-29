package com.impos.pmv.controller;

import com.impos.pmv.model.dto.CategoriaDto;
import com.impos.pmv.service.CategoriaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping("/categoria")
	public ResponseEntity<?> Post(@Valid @RequestBody CategoriaDto categoriaDto) {

		return ResponseEntity.ok(categoriaService.save(categoriaDto));
	}

	@GetMapping("/categoria")
	public ResponseEntity<?> Get() {
		return ResponseEntity.ok(categoriaService.findAll());
	}

	@PutMapping("/categoria")
	public ResponseEntity<?> Get(@Valid @RequestBody CategoriaDto categoriaDto) {
		return ResponseEntity.ok(categoriaService.update(categoriaDto));
	}
}
