package com.projetohosp.controller;

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

import com.projetohosp.entities.Aposento;
import com.projetohosp.service.AposentoService;

public class AposentoController {
private final AposentoService aposentoService;
	
	@Autowired
	public AposentoController(AposentoService aposentoService) {
		this.aposentoService = aposentoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aposento> buscaAposentoControllId(@ PathVariable Long id){
		Aposento aposento = aposentoService.buscaAposentoId(id);
		if(aposento != null) {
			return ResponseEntity.ok(aposento);
		}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Aposento>> buscaTodosAposentosControl(){
		List<Aposento> aposento = aposentoService.buscaTodosAposento();
		return ResponseEntity.ok(aposento);
	}
	
	@PostMapping("/")
	public ResponseEntity<Aposento> salvaAposentosControl(@RequestBody Aposento aposento){
		Aposento salvaAposento = aposentoService.salvaAposento(aposento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaAposento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aposento> alteraAposentoControl(@PathVariable Long id, @RequestBody Aposento aposento){
		Aposento alteraAposento = aposentoService.alterarAposento(id, aposento);
		if(alteraAposento != null) {
			return ResponseEntity.ok(aposento);
		}
		
		else {
			return ResponseEntity.notFound().build();	
	  }
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaAposentoControl(@PathVariable Long id){
		boolean apagar = aposentoService.apagarAposento(id);
	if (apagar) {
		return ResponseEntity.ok().body("O Produto foi excluído com sucesso");
	}
	
	else {
		return ResponseEntity.notFound().build();
	}
	
   }

}
