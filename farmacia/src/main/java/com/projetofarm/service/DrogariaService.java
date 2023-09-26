package com.projetofarm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetofarm.entities.Drogaria;
import com.projetofarm.repository.DrogariaRepository;

public class DrogariaService {
		private final DrogariaRepository drogariaRepository; 
		@Autowired
		public DrogariaService(DrogariaRepository drogariaRepository) {
			this.drogariaRepository = drogariaRepository;
		}
		
		public List<Drogaria> buscaTodosDrogaria(){
			return drogariaRepository.findAll();
		}
		
		public Drogaria buscaDrogariaId(Long id) {
			Optional<Drogaria> funcionario = drogariaRepository.findById(id);
			return funcionario.orElse(null);
		}
		
		public Drogaria salvaDrogaria(Drogaria drogaria) {
			return drogariaRepository.save(drogaria);
		}
		
		public Drogaria alterarDrogaria(Long id, Drogaria alterarDrog) {
			Optional <Drogaria> existeDrogaria = drogariaRepository.findById(id);
			if (existeDrogaria.isPresent()) {
				alterarDrog.setId(id);
				return drogariaRepository.save(alterarDrog);
			}
			return null;
		}
		
		public boolean apagarDrogaria(long id) {
			Optional<Drogaria> existeDrogaria = drogariaRepository.findById(id);
			if (existeDrogaria.isPresent()) {
				drogariaRepository.deleteById(id);
				return true;
			}
			return false;
		}
}
