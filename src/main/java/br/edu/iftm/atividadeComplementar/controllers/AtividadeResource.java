package br.edu.iftm.atividadeComplementar.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.atividadeComplementar.domains.Atividade;
import br.edu.iftm.atividadeComplementar.services.AtividadeService;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeResource {

	@Autowired
	private AtividadeService service;

	@RequestMapping(value = "like/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		List<Atividade> atividades = service.buscar(nome);
		return ResponseEntity.ok().body(atividades);
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.GET)
	public ResponseEntity<?> findByRa(@PathVariable Long codigo) {
		Optional<Atividade> atividades = service.buscarCodigo(codigo);
		return ResponseEntity.ok().body(atividades);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Atividade> atividades = service.buscarTodos();
		return ResponseEntity.ok().body(atividades);
	}

}
