package com.projetofarm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetofarm.entities.Medicamento;
import com.projetofarm.repository.MedicamentoRepository;

public class MedicamentoService {
	private final MedicamentoRepository medicamentoRepository; 
	@Autowired
	public MedicamentoService(MedicamentoRepository medicamentoRepository) {
		this.medicamentoRepository = medicamentoRepository;
	}
	
	public List<Medicamento> buscaTodosMedicamento(){
		return medicamentoRepository.findAll();
	}
	
	public Medicamento buscaMedicamentoId(Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		return medicamento.orElse(null);
	}
	
	public Medicamento salvaMedicamento(Medicamento medicamento) {
		return medicamentoRepository.save(medicamento);
	}
	
	public Medicamento alterarMedicamento(Long id, Medicamento alterarMed) {
		Optional <Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			alterarMed.setId(id);
			return medicamentoRepository.save(alterarMed);
		}
		return null;
	}
	
	public boolean apagarMedicamento(long id) {
		Optional<Medicamento> existeMedicamento = medicamentoRepository.findById(id);
		if (existeMedicamento.isPresent()) {
			medicamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
