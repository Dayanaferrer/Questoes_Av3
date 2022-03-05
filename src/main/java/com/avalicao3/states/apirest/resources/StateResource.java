package com.avalicao3.states.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avalicao3.states.apirest.dto.AreaDTO;
import com.avalicao3.states.apirest.dto.PopulacaoDTO;
import com.avalicao3.states.apirest.dto.RegiaoDTO;
import com.avalicao3.states.apirest.entities.State;
import com.avalicao3.states.apirest.services.StateService;

@RestController
@RequestMapping(value = "/api/states")
public class StateResource {
	
	@Autowired
	private StateService service;
	
	@GetMapping
	public ResponseEntity<List<State>> findAll(){		
		List<State> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<State> findById(@PathVariable Long id){
		State obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/regiao")
	public ResponseEntity<List<RegiaoDTO>> buscarPorRegiao(@RequestParam String nome){
		return ResponseEntity.ok(service.buscarPorRegiao(nome));
	}
	@GetMapping(value = "/populacao")
	public ResponseEntity<List<PopulacaoDTO>> buscarPorMaiorPopulacao(@RequestParam Long valor) {
		return ResponseEntity.ok(service.buscarPorMaiorPopulacao(valor));
	}
	@GetMapping(value = "/area")
	public ResponseEntity<List<AreaDTO>> buscarPorMaiorArea(@RequestParam Double valor) {
		return ResponseEntity.ok(service.buscarPorMaiorArea(valor));
	}
	
	
}