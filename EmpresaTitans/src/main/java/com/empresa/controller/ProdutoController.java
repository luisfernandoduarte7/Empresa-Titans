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

import com.empresa.entities.Produto;

import com.empresa.service.ProdutoService;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Produto")
public class ProdutoController {
		
		private final ProdutoService ProdutoService;

		@Autowired
		public ProdutoController(ProdutoService ProdutoService) {
			this.ProdutoService = ProdutoService;
		}

		@GetMapping ("/{id}")
		public ResponseEntity<Produto> buscaProdutoIdControlId (@ PathVariable Long id) {
			Produto Produto = ProdutoService.buscaProdutoId(id);
			if (Produto != null) {
				return ResponseEntity.ok(Produto);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		@GetMapping("/nome/{nome}")
		public List<Produto> findProdutoPorNome(@PathVariable String nome){
			return ProdutoService.findByNome(nome);
		}
		@GetMapping("/preco/{preco}")
		public List<Produto> findProdutoPorPreco(@PathVariable double preco){
			return ProdutoService.findByPreco(preco);
		}
		@GetMapping("/")
		public ResponseEntity<List<Produto>> buscaTodosProdutoControl(){
			List<Produto> Produto = ProdutoService.buscaTodosProduto();
			return ResponseEntity.ok(Produto);
		}
		@PostMapping("/")
		public ResponseEntity<Produto> salvaProdutoControl(@RequestBody  Produto Produto){
			Produto salvaProduto= ProdutoService.salvaProduto(Produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaProduto);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Produto> alterarProdutoControl(@PathVariable Long id, @RequestBody Produto Produto){
			Produto alterarProduto = ProdutoService.alterarProduto(id, Produto);
			if(alterarProduto != null) {
				return ResponseEntity.ok(alterarProduto);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaProdutoControl(@PathVariable Long id){
			boolean Produto = ProdutoService.apagarProduto(id);
			if (Produto) {
				return ResponseEntity.ok().body("O Produto foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}