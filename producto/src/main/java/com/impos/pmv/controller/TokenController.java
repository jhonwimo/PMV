/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impos.pmv.controller;


import com.impos.pmv.model.dto.User;

import com.impos.pmv.model.entity.TblUsuarios;
import com.impos.pmv.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jwmoreno
 */
@RestController
public class TokenController {
    
    
    
        @Autowired
    private UsuarioService UsuarioService;

    private String getJWTToken(String username,String rol) {
        String secretKey = "pruebaPruductoMinimoViable";
        List<GrantedAuthority> grantedAuthorities ;
        
         
          if(rol.equals("ADMIN")){
        grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
          }else{
           grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");    
          }

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

       return "Bearer " + token;
    }

    
    
        @PostMapping("token")
	public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        	TblUsuarios usu=UsuarioService.findByNombreUsuarioAndClave(username, pwd);
		String token = getJWTToken(username,usu.getNivelAcceso());
		User user = new User();
		user.setUser(username);
		user.setToken(token);		
		return user;
		
	}

	
}
