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

import com.projetojpa.entities1.Fornecedor;
import com.projetojpa.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	    
		private final FornecedorService fornecedorService;

	    @Autowired
	    public FornecedorController(FornecedorService fornecedorService) {
	        this.fornecedorService = fornecedorService;
	    }

	    @PostMapping
	    public Fornecedor createFornecedor(@RequestBody Fornecedor fornecedor) {
	        return fornecedorService.saveFornecedor(fornecedor);
	    }

	    @GetMapping("/{id}")
	    public Fornecedor getFornecedor(@PathVariable Long id) {
	        return fornecedorService.getFornecedorById(id);
	    }

	    @GetMapping
	    public List<Fornecedor> getAllProdutos() {
	        return fornecedorService.getAllFornecedor();
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduto(@PathVariable Long id) {
	    	fornecedorService.deleteFornecedor(id);
	    }
	}

