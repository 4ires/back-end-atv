package com.projetohosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohosp.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>  {

}
