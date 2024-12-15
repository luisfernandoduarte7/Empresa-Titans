package com.empresa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendedor")
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto", nullable = false)
	private Long id;
	
	@Column(name = "meta", nullable = false, length = 100)
	private double meta;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "salario", nullable = false, length = 100)
	private double salario;
	
	@Column(name = "qtde", nullable = false, length = 100)
	private String qtde;
	
	@Column(name = "setor", nullable = false, length = 100)
	private String setor;
	
	@Column(name = "totalvendas", nullable = false, length = 100)
	private double totalvendas;
	
	@ManyToOne
	@JoinColumn(name = "id_equipe")
	private Equipe equipe;
		
}