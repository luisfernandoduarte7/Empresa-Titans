package com.empresa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entities.Vendedor;

public interface VendedorRepository extends JpaRepository <Vendedor, Long> {

	@Query("SELECT a FROM Vendedor a WHERE a.nome = :nome")
	List<Vendedor>findByNome(String nome);
	
	@Query("SELECT a FROM Vendedor a WHERE a.meta = :meta")
	List<Vendedor>findByMeta(double meta);

}
