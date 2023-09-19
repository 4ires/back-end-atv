package com.projetohosp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetohosp.entities.Aposento;
import com.projetohosp.repository.AposentoRepository;

public class AposentoService {
private final AposentoRepository aposentoRepository; 
	
	@Autowired
	public AposentoService(AposentoRepository aposentoRepository) {
		this.aposentoRepository = aposentoRepository;
	}
	
	public List<Aposento> buscaTodosAposento(){
		return aposentoRepository.findAll();
	}
	
	public Aposento buscaAposentoId(Long id) {
		Optional<Aposento> aposento = aposentoRepository.findById(id);
		return aposento.orElse(null);
	}
	
	public Aposento salvaAposento(Aposento aposento) {
		return aposentoRepository.save(aposento);
	}
	
	public Aposento alterarAposento(Long id, Aposento alterarAp) {
		Optional <Aposento> existeAposento = aposentoRepository.findById(id);
		if (existeAposento.isPresent()) {
			alterarAp.setId(id);
			return aposentoRepository.save(alterarAp);
		}
		return null;
	}
	
	public boolean apagarAposento(long id) {
		Optional<Aposento> existeAposento = aposentoRepository.findById(id);
		if (existeAposento.isPresent()) {
			aposentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
