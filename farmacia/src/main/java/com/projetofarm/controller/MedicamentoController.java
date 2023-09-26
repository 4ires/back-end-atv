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

import com.projetofarm.entities.Medicamento;
import com.projetofarm.service.MedicamentoService;

public class MedicamentoController {
private final MedicamentoService medicamentoService;
	
	@Autowired
	public MedicamentoController(MedicamentoService medicamentoService) {
		this.medicamentoService = medicamentoService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> buscaMedicamentoControllId(@ PathVariable Long id){
		Medicamento medicamento = medicamentoService.buscaMedicamentoId(id);
		if(medicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
			else {
				return ResponseEntity.notFound().build();
			}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Medicamento>> buscaTodosMedicamentoControl(){
		List<Medicamento> medicamento = medicamentoService.buscaTodosMedicamento();
		return ResponseEntity.ok(medicamento);
	}
	
	@PostMapping("/")
	public ResponseEntity<Medicamento> salvaMedicamentoControl(@RequestBody Medicamento medicamento){
		Medicamento salvaMedicamento = medicamentoService.salvaMedicamento(medicamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaMedicamento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Medicamento> alteraMedicamentoControl(@PathVariable Long id, @RequestBody Medicamento medicamento){
		Medicamento alteraMedicamento = medicamentoService.alterarMedicamento(id, medicamento);
		if(alteraMedicamento != null) {
			return ResponseEntity.ok(medicamento);
		}
		
		else {
			return ResponseEntity.notFound().build();	
	  }
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaMedicamentoControl(@PathVariable Long id){
		boolean apagar = medicamentoService.apagarMedicamento(id);
	if (apagar) {
		return ResponseEntity.ok().body("O Produto foi excluído com sucesso");
	}
	
	else {
		return ResponseEntity.notFound().build();
	}
	
   }
}
