package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities1.Usuario;
import com.projetojpa.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	    
		private final UsuarioService usuarioService;

	    @Autowired 
	    public UsuarioController(UsuarioService usuarioService) {
	        this.usuarioService = usuarioService;
	    }

	    @PostMapping
	    public Usuario createProduct(@RequestBody Usuario usuario) {
	        return usuarioService.saveUsuario(usuario);
	    }

	    @GetMapping("/{id}")
	    public Usuario getUsuario(@PathVariable Long id) {
	        return usuarioService.getUsuarioById(id);
	    }

	    @GetMapping
	    public List<Usuario> getAllUsuarios() {
	        return usuarioService.getAllUsuario();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUsuario(@PathVariable Long id) {
	    	usuarioService.deleteUsuario(id);
	    }
	}

