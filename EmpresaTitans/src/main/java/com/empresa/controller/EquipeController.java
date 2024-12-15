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

import com.empresa.entities.Equipe;

import com.empresa.service.EquipeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/equipe")
public class EquipeController {
		
		private final EquipeService EquipeService;

		@Autowired
		public EquipeController(EquipeService EquipeService) {
			this.EquipeService = EquipeService;
		}
        //Query 
		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Equipe>>buscaporEquipePorNome(@PathVariable String nome){
			List<Equipe> equipe = EquipeService.findByNome(nome);
			return ResponseEntity.ok(equipe);
		}
		
		@GetMapping("/cidade/{cidade}")
		public ResponseEntity<List<Equipe>>buscaporEquipePorCidade(@PathVariable String cidade){
			List<Equipe> equipe = EquipeService.findByCidade(cidade);
			return ResponseEntity.ok(equipe);
		}
		@GetMapping("/email/{email}")
		public ResponseEntity<List<Equipe>>buscaporEquipePorEmail(@PathVariable String email){
			List<Equipe> equipe = EquipeService.findByEmail(email);
			return ResponseEntity.ok(equipe);
		}
		
		@GetMapping ("/{id}")
		public ResponseEntity<Equipe> buscaEquipeIdControlId (@ PathVariable Long id) {
			Equipe Equipe = EquipeService.buscaEquipeId(id);
			if (Equipe != null) {
				return ResponseEntity.ok(Equipe);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}

		/*@GetMapping("/nome/{nome}")
		public List<Equipe> findEquipePorNome(@PathVariable String nome){
			return EquipeService.findByNome(nome);*/
		@GetMapping("/")
		public ResponseEntity<List<Equipe>> buscaTodosEquipeControl(){
			List<Equipe> Equipe = EquipeService.buscaTodosEquipe();
			return ResponseEntity.ok(Equipe);
		}
		@PostMapping("/")
		public ResponseEntity<Equipe> salvaEquipeControl(@RequestBody  Equipe Equipe){
			Equipe salvaEquipe= EquipeService.salvaEquipe(Equipe);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvaEquipe);
		}
		@PutMapping("/{id}")
		public ResponseEntity<Equipe> alterarEquipeControl(@PathVariable Long id, @RequestBody Equipe Equipe){
			Equipe alterarEquipe = EquipeService.alterarEquipe(id, Equipe);
			if(alterarEquipe != null) {
				return ResponseEntity.ok(alterarEquipe);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> apagaEquipeControl(@PathVariable Long id){
			boolean Equipe = EquipeService.apagarEquipe(id);
			if (Equipe) {
				return ResponseEntity.ok().body("O Equipe foi excluído com sucesso");
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
}