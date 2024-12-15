package com.empresa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.empresa.entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
	
	@Query("SELECT a FROM equipe a WHERE a.nome = :nome")
	List<Equipe>findByNome(String nome);
	
	@Query("SELECT a FROM equipe a WHERE a.cidade = :cidade")
	List<Equipe>findByCidade(String cidade);
	
	@Query("SELECT a FROM equipe a WHERE a.email = :email")
	List<Equipe> findByEmail (@Param("email") String email);
	
	

}
