package com.gerenciamento.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;
	private String dataLimiteExecucao;
	private String detalhesTarefa;
	private String statusTarefa;

	@NotNull
	@NotBlank
	@Size(min = 8,message= "Mínimo de 8 caracteres")
	@Column
	private String cnpj;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataLimiteExecucao() {
		return dataLimiteExecucao;
	}
	public void setDataLimiteExecucao(String dataLimiteExecucao) {
		this.dataLimiteExecucao = dataLimiteExecucao;
	}
	public String getDetalhesTarefa() {
		return detalhesTarefa;
	}
	public void setDetalhesTarefa(String detalhesTarefa) {
		this.detalhesTarefa = detalhesTarefa;
	}
	public String getStatusTarefa() {
		return statusTarefa;
	}
	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
}

