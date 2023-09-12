package com.projetojpa.entities1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "fornecedor")
public class Fornecedor {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		 
		@Column(name = "razão social")
		private String razaoSocial;
		
		@Column(name = "nome fantasia")
		private String nomeFantasia;
		
		@Column(name = "cnpj")
		private String cnpj;
		
		@Column(name = "endereço")
		private String endereco;
		
		@Column(name = "fone")
		private String fone;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "inscrico estadual")
		private String inscricaoEstadual;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getrazaoSocial() {
			return razaoSocial;
		}
		public void setrazaoSocial(String razaoSocial) {
			this.razaoSocial = razaoSocial;
		}
		public String getnomeFantasia() {
			return nomeFantasia;
		}
		public void setnomeFantasia(String nomeFantasia) {
			this.nomeFantasia = nomeFantasia;
		}
		
		public String getcnpj() {
			return cnpj;
		}
		public void setcnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		
		public String getendereco() {
			return endereco;
		}
		public void setendereco(String endereco) {
			this.endereco = endereco;
		}
		
		public String getfone() {
			return fone;
		}
		public void setfone(String fone) {
			this.fone = fone;
		}
		
		public String getemail() {
			return email;
		}
		public void setemail(String email) {
			this.email = email;
		}
		
		public String getinscricaoEstadual() {
			return inscricaoEstadual;
		}
		public void setinscricaoEstadual(String inscricaoEstadual) {
			this.inscricaoEstadual = inscricaoEstadual;
		}
}

