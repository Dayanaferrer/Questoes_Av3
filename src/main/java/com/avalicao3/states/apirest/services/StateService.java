package com.avalicao3.states.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
