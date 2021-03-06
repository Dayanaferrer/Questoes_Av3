package com.avaliacao3.states.apirest.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.avaliacao3.states.apirest.dto.AreaDTO;
import com.avaliacao3.states.apirest.dto.PopulacaoDTO;
import com.avaliacao3.states.apirest.dto.RegiaoDTO;
import com.avaliacao3.states.apirest.entities.State;
import com.avaliacao3.states.apirest.repositories.StateRepository;
import com.avaliacao3.states.apirest.services.exception.ObjNotFoundException;
import com.avaliacao3.states.apirest.services.exception.ResourceNotFoundException;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State>findAll(){
		return repository.findAll();
	}
	
	public State findById(Long id) {
		Optional<State> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ResourceNotFoundException("ID: " + id + " <- não foi encontrado"));
	}
	
	
	public List<RegiaoDTO>buscarPorRegiao(String nome){
		List<RegiaoDTO>listarPorRegiao = repository.findAll().stream().filter
		(state -> state.getRegiao().equalsIgnoreCase(nome)).map(RegiaoDTO::new).collect(Collectors.toList());
		return listarPorRegiao;
	}
	
	
	public List <PopulacaoDTO>buscarPorMaiorPopulacao(Long valor){
		List<PopulacaoDTO> listarPorPopulacao = repository.findAll().stream().filter(state -> state.getPopulacao() >= valor)
		.sorted(Comparator.comparing(State::getPopulacao).reversed()).map(PopulacaoDTO::new).collect(Collectors.toList());
		return listarPorPopulacao;
	}
	
	public List<AreaDTO> buscarPorMaiorArea(Double valor){
		List<AreaDTO> listaPorAreas = repository.findAll().stream().filter(state -> state.getArea() >= valor)
		.sorted(Comparator.comparing(State::getArea).reversed()).map(AreaDTO::new).collect(Collectors.toList());
		return listaPorAreas;	
	}
	
	public State insert (State obj) {
		return repository.save(obj);
	}
	
	public void delete (Long id) {
		try {
		repository.deleteById(id);
	}catch (EmptyResultDataAccessException e){
		throw new ResourceNotFoundException(id);
	}catch(ObjNotFoundException e) {
		throw new ResourceNotFoundException(e.getMessage());
	}
}
	public State update (Long id, State obj) {
		State entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(State entity, State obj) {
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());
		entity.setRegiao(obj.getRegiao());
		entity.setPopulacao(obj.getPopulacao());
		entity.setCapital(obj.getCapital());
		entity.setArea(obj.getArea());
		
	}
	
}