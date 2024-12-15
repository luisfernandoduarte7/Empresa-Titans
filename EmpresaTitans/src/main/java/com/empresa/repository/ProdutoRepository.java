package com.empresa.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	@Query("SELECT a FROM Produto a WHERE a.produto = :produto")
	List<Produto>findByNome(String nome);

	@Query("SELECT a FROM Produto a WHERE a.preco = :preco")
	List<Produto>findByPreco(double preco);

	@Query("SELECT a FROM Produto a WHERE a.descricao = :descricao")
	List<Produto>findByDescricao(String descricao);

}
