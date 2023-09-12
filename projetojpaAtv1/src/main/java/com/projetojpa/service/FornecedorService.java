package com.projetojpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities1.Fornecedor;
import com.projetojpa.repository.FornecedorRepository;

@Service
public class FornecedorService {

	    private final FornecedorRepository fornecedorRepository;

	
	    @Autowired
	    public FornecedorService(FornecedorRepository fornecedorRepository) {
	        this.fornecedorRepository = fornecedorRepository;
	    }

	    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
	        return fornecedorRepository.save(fornecedor);
	    }

	    public Fornecedor getFornecedorById(Long id) {
	        return fornecedorRepository.findById(id).orElse(null);
	    }

	    public List<Fornecedor> getAllFornecedor() {
	        return fornecedorRepository.findAll();
	    }

	    public void deleteFornecedor(Long id) {
	    	fornecedorRepository.deleteById(id);
	    }
	}

	

