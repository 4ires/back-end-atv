package com.gerenciamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gerenciamento.entities.ItemExecucao;
import com.gerenciamento.repository.ItemExecucaoRepository;

public class ItemExecucaoService {
	private final ItemExecucaoRepository itemExecucaoRepository; 
	@Autowired
	public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
		this.itemExecucaoRepository = itemExecucaoRepository;
	}
	
	public List<ItemExecucao> buscaTodosItemExecucao(){
		return itemExecucaoRepository.findAll();
	}
	
	public ItemExecucao buscaItemExecucaoId(Long id) {
		Optional<ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
		return itemExecucao.orElse(null);
	}
	
	public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) {
		return itemExecucaoRepository.save(itemExecucao);
	}
	
	public ItemExecucao alterarItemExecucao(Long id, ItemExecucao alterarItExec) {
		Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
		if (existeItemExecucao.isPresent()) {
			alterarItExec.setId(id);
			return itemExecucaoRepository.save(alterarItExec);
		}
		return null;
	}
	
	public boolean apagarItemExecucao(long id) {
		Optional<ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
		if (existeItemExecucao.isPresent()) {
			itemExecucaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
