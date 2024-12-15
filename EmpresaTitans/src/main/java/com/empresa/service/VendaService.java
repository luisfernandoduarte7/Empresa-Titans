package com.empresa.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Venda;
import com.empresa.repository.VendaRepository;

@Service
public class VendaService {
	
	private final VendaRepository VendaRepository;

	@Autowired
	public VendaService(VendaRepository VendaRepository) {
		this.VendaRepository = VendaRepository;
	}

	public List<Venda> buscaTodosVenda(){
		return VendaRepository.findAll();
	}
	
/*	//@query
	public List<Venda> findByVenda(Date data) {
		return VendaRepository.findByVenda(data);
	} */
	public Venda buscaVendaId (Long id) {
		Optional <Venda> Venda = VendaRepository.findById(id);
		return Venda.orElse(null);			
	}
	
	public Venda salvaVenda(Venda Venda) {
		return VendaRepository.save(Venda);
	}
	
	public Venda alterarVenda(Long id, Venda alterarVenda) {
		Optional <Venda> existeVenda = VendaRepository.findById(id);
		if (existeVenda.isPresent()) {
			alterarVenda.setId(id);
			return VendaRepository.save(alterarVenda);
		}
		return null;
	}

	public boolean apagarVenda(Long id) {
		Optional <Venda> existeVenda = VendaRepository.findById(id);
		if (existeVenda.isPresent()) {
			VendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}