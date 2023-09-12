package com.projetojpa.repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.projetojpa.entities1.Fornecedor;

	public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
