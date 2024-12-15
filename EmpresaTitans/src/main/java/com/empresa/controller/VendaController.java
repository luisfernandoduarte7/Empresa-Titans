package com.empresa.controller;


import java.sql.Date;
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

import com.empresa.entities.Venda;
import com.empresa.service.VendaService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/venda")
public class VendaController {
		
		private final VendaService VendaService;

		@Autowired
		public VendaController(VendaService VendaService) {
			this.VendaService = VendaService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Venda> buscaVendaIdControlId (@ PathVariable Long id) {
			Venda Venda = VendaService.buscaVendaId(id);
			if (Venda != null) {
				return ResponseEntity.ok(Venda);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	
		/*@GetMapping("/nome/{nome}")
		public List<Venda> findProdutoPorNome(@PathVariable Date data){
			return VendaService.findByVenda(data);
		} */
		@GetMapping("/")
		public ResponseEntity<List<Venda>> buscaTodosVendaControl(){
			List<Venda> Venda = VendaService.buscaTodosVenda();
			return ResponseEntity.ok(Venda);
		}
		@PostMapping("/")
		public ResponseEntity<Venda> salvaVendaControl(@RequestBody  Venda Venda){
			Venda salvaVenda= VendaService.salvaVenda(Venda);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaVenda);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Venda> alterarVendaControl(@PathVariable Long id, @RequestBody Venda Venda){
			Venda alterarVenda = VendaService.alterarVenda(id, Venda);
			if(alterarVenda != null) {
				return ResponseEntity.ok(alterarVenda);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaVendaControl(@PathVariable Long id){
			boolean Venda = VendaService.apagarVenda(id);
			if (Venda) {
				return ResponseEntity.ok().body("O Venda foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}