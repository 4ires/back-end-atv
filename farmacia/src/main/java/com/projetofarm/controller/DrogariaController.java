package com.projetofarm.controller;

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

import com.projetofarm.entities.Drogaria;
import com.projetofarm.service.DrogariaService;

public class DrogariaController {
private final DrogariaService drogariaService;
	
	@Autowired
	public DrogariaController(DrogariaService drogariaService) {
		this.drogariaService = drogariaService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Drogaria> buscaDrogariaControllId(@ PathVariable Long id){
		Drogaria drogaria = drogariaService.buscaDrogariaId(id);
		if(drogaria != null) {
			return ResponseEntity.ok(drogaria);
		}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Drogaria>> buscaTodosDrogariaControl(){
		List<Drogaria> Drogaria = drogariaService.buscaTodosDrogaria();
		return ResponseEntity.ok(Drogaria);
	}
	
	@PostMapping("/")
	public ResponseEntity<Drogaria> salvaDrogariaControl(@RequestBody Drogaria drogaria){
		Drogaria salvaDrogaria = drogariaService.salvaDrogaria(drogaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaDrogaria);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Drogaria> alteraHospedeControl(@PathVariable Long id, @RequestBody Drogaria drogaria){
		Drogaria alteraDrogaria = drogariaService.alterarDrogaria(id, drogaria);
		if(alteraDrogaria != null) {
			return ResponseEntity.ok(drogaria);
		}
		
		else {
			return ResponseEntity.notFound().build();	
	  }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaDrogariaControl(@PathVariable Long id){
		boolean apagar = drogariaService.apagarDrogaria(id);
	if (apagar) {
		return ResponseEntity.ok().body("O Produto foi excluído com sucesso");
	}
	
	else {
		return ResponseEntity.notFound().build();
	}
	
   }

}
