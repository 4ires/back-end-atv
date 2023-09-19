package com.projetohosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetohosp.entities.Hospede;

public interface HospedeRepository extends JpaRepository<Hospede, Long> {
	
}

