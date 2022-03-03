package com.avalicao3.states.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avalicao3.states.entities.States;

@RestController
@RequestMapping(value = "/states")
public class StatesResource {
	
	@GetMapping
	public ResponseEntity<States> findAll(){		//Vai retornar os estados
		States estado = new States(1L, "Rio Grande do Norte", "Nordeste", 3409000L, "Natal", 52.797);
		return ResponseEntity.ok().body(estado);
	}
	

}
