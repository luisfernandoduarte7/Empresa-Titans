package com.empresa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entities.Vendedor;

import com.empresa.service.VendedorService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Vendedor")
public class  VendedorController {
		
		private final VendedorService VendedorService;

		@Autowired
		public VendedorController(VendedorService VendedorService) {
			this.VendedorService = VendedorService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Vendedor> buscaVendedorIdControlId (@ PathVariable Long id) {
			Vendedor Vendedor = VendedorService.buscaVendedorId(id);
			if (Vendedor != null) {
				return ResponseEntity.ok(Vendedor);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/nome/{nome}")
		public List<Vendedor> findVendedorPorNome(@PathVariable String nome){
			return VendedorService.findByNome(nome);
		}
		@GetMapping("/meta/{meta}")
		public List<Vendedor> findVendedorPorMeta(@PathVariable double meta){
			return VendedorService.findByMeta(meta);
		}
		@GetMapping("/")
		public ResponseEntity<List<Vendedor>> buscaTodosVendedorControl(){
			List<Vendedor> Vendedor = VendedorService.buscaTodosVendedor();
			return ResponseEntity.ok(Vendedor);
		}
		@PostMapping("/")
		public ResponseEntity<Vendedor> salvaVendedorControl(@RequestBody  Vendedor Vendedor){
			Vendedor salvaVendedor= VendedorService.salvaVendedor(Vendedor);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaVendedor);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Vendedor> alterarVendedorControl(@PathVariable Long id, @RequestBody Vendedor Vendedor){
			Vendedor alterarVendedor = VendedorService.alterarVendedor(id, Vendedor);
			if(alterarVendedor != null) {
				return ResponseEntity.ok(alterarVendedor);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaVendedorControl(@PathVariable Long id){
			boolean Vendedor = VendedorService.apagarVendedor(id);
			if (Vendedor) {
				return ResponseEntity.ok().body("O Vendedor foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}