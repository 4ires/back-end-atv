package com.gerenciamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciamento.entities.ItemExecucao;
import com.gerenciamento.service.ItemExecucaoService;

public class ItemExecucaoController {
private final ItemExecucaoService itemExecucaoService;
	
	@Autowired
	public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
		this.itemExecucaoService = itemExecucaoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemExecucao> buscaItemExecucaoControllId(@ PathVariable Long id){
		ItemExecucao itemExecucao = itemExecucaoService.buscaItemExecucaoId(id);
		if(itemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaoControl(){
		List<ItemExecucao> ItemExecucao = itemExecucaoService.buscaTodosItemExecucao();
		return ResponseEntity.ok(ItemExecucao);
	}
	
	@PostMapping("/")
	public ResponseEntity<ItemExecucao> salvaItemExecucaoControl(@RequestBody ItemExecucao itemExecucao){
		ItemExecucao salvaItemExecucao = itemExecucaoService.salvaItemExecucao(itemExecucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemExecucao);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemExecucao> alteraItemExecucaoControl(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao){
		ItemExecucao alteraItemExecucao = itemExecucaoService.alterarItemExecucao(id, itemExecucao);
		if(alteraItemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		}
		
		else {
			return ResponseEntity.notFound().build();	
	  }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaItemExecucaoControl(@PathVariable Long id){
		boolean apagar = itemExecucaoService.apagarItemExecucao(id);
	if (apagar) {
		return ResponseEntity.ok().body("O Produto foi excluído com sucesso");
	}
	
	else {
		return ResponseEntity.notFound().build();
	}
	
   }

}
