package com.projetohosp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetohosp.entities.Hospede;
import com.projetohosp.repository.HospedeRepository;

public class HospedeService {
private final HospedeRepository hospedeRepository; 
	
	@Autowired
	public HospedeService(HospedeRepository hospedeRepository) {
		this.hospedeRepository = hospedeRepository;
	}
	
	public List<Hospede> buscaTodosHospede(){
		return hospedeRepository.findAll();
	}
	
	public Hospede buscaHospedeId(Long id) {
		Optional<Hospede> hospede = hospedeRepository.findById(id);
		return hospede.orElse(null);
	}
	
	public Hospede salvaHospede(Hospede hospede) {
		return hospedeRepository.save(hospede);
	}
	
	public Hospede alterarHospede(Long id, Hospede alterarHosp) {
		Optional <Hospede> existeHospede = hospedeRepository.findById(id);
		if (existeHospede.isPresent()) {
			alterarHosp.setId(id);
			return hospedeRepository.save(alterarHosp);
		}
		return null;
	}
	
	public boolean apagarHospede(long id) {
		Optional<Hospede> existeHospede = hospedeRepository.findById(id);
		if (existeHospede.isPresent()) {
			hospedeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

