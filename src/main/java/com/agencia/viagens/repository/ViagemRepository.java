package com.agencia.viagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agencia.viagens.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{
	
	Viagem findById(long id);
}
