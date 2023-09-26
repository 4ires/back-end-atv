package com.projetofarm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projetofarm.entities.Medicamento;

public interface MedicamentoRepository  extends JpaRepository<Medicamento, Long>{

}
