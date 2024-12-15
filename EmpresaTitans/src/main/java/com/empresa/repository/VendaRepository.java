package com.empresa.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entities.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long>{

	//@Query("SELECT a FROM venda a WHERE a.data = :data")
	//List<Venda>findByVenda(Date data);
	
	

}
