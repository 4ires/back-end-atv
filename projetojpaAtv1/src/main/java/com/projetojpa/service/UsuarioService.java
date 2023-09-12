package com.projetojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities1.Usuario;
import com.projetojpa.repository.UsuarioRepository;

@Service
public class UsuarioService {
	    private final UsuarioRepository usuarioRepository;

	    @Autowired
	    public UsuarioService(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    public Usuario saveUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }

	    public Usuario getUsuarioById(Long id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }

	    public List<Usuario> getAllUsuario() {
	        return usuarioRepository.findAll();
	    }

	    public void deleteUsuario(Long id) {
	    	usuarioRepository.deleteById(id);
	    }
	}



