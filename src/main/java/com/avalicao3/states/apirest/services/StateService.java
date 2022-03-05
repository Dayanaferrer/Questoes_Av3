package com.avalicao3.states.apirest.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalicao3.states.apirest.dto.RegiaoDTO;
import com.avalicao3.states.apirest.entities.State;
import com.avalicao3.states.apirest.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State>findAll(){
		return repository.findAll();
	}
	public State findById(Long id) {
		Optional<State> obj = repository.findById(id);
		return obj.get();		
	}
	
	public List<RegiaoDTO>buscarPorRegiao(String nome){
		List<RegiaoDTO>listarPorRegiao = repository.findAll().stream().filter
				(state -> state.getRegiao().equalsIgnoreCase(nome)).map(RegiaoDTO::new).collect(Collectors.toList());
		return listarPorRegiao;
	}
}
