package com.impos.pmv.controller;




import com.impos.pmv.model.dto.UsuarioDto;

import com.impos.pmv.service.UsuarioService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController

public class UsuarioController {
 

    @Autowired
    private UsuarioService UsuarioService;

    
   
   
    @PostMapping("/usuario")
    public ResponseEntity<?> Post(@Valid @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(UsuarioService.save(usuarioDto));
        
    }

    @GetMapping("/usuario")
    public  ResponseEntity<?> Get() {
       return ResponseEntity.ok(UsuarioService.findAll());
    }

    @PutMapping("/usuario")
    public ResponseEntity<?> Get(@Valid @RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(UsuarioService.update(usuarioDto));
    }
    
    
    
    
    
    
    
}
