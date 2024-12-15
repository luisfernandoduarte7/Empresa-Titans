package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Vendedor;
import com.empresa.repository.VendedorRepository;

@Service
public class VendedorService {
	
	private final VendedorRepository VendedorRepository;

	@Autowired
	public VendedorService(VendedorRepository VendedorRepository) {
		this.VendedorRepository = VendedorRepository;
	}

	public List<Vendedor> buscaTodosVendedor(){
		return VendedorRepository.findAll();
	}
	
	//@query
	public List<Vendedor> findByNome(String nome) {
		return VendedorRepository.findByNome(nome);
	}
	
	//@query
		public List<Vendedor> findByMeta(double meta) {
			return VendedorRepository.findByMeta(meta);
	}
		
	public Vendedor buscaVendedorId (Long id) {
		Optional <Vendedor> Vendedor = VendedorRepository.findById(id);
		return Vendedor.orElse(null);			
	}
	
	public Vendedor salvaVendedor(Vendedor Vendedor) {
		return VendedorRepository.save(Vendedor);
	}
	
	public Vendedor alterarVendedor(Long id, Vendedor alterarVendedor) {
		Optional <Vendedor> existeVendedor = VendedorRepository.findById(id);
		if (existeVendedor.isPresent()) {
			alterarVendedor.setId(id);
			return VendedorRepository.save(alterarVendedor);
		}
		return null;
	}

	public boolean apagarVendedor(Long id) {
		Optional <Vendedor> existeVendedor = VendedorRepository.findById(id);
		if (existeVendedor.isPresent()) {
			VendedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}