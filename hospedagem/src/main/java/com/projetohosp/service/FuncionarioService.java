package com.projetohosp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetohosp.entities.Funcionario;
import com.projetohosp.entities.Funcionario;
import com.projetohosp.repository.AposentoRepository;
import com.projetohosp.repository.FuncionarioRepository;

public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository; 
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> buscaTodosFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario buscaFuncionarioId(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return funcionario.orElse(null);
	}
	
	public Funcionario salvaFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Funcionario alterarFuncionario(Long id, Funcionario alterarFunc) {
		Optional <Funcionario> existeFuncionario = funcionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			alterarFunc.setId(id);
			return funcionarioRepository.save(alterarFunc);
		}
		return null;
	}
	
	public boolean apagarFUncionario(long id) {
		Optional<Funcionario> existeFuncionario = funcionarioRepository.findById(id);
		if (existeFuncionario.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
