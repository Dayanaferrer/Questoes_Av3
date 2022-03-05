package com.avalicao3.states.apirest.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avalicao3.states.apirest.dto.AreaDTO;
import com.avalicao3.states.apirest.dto.PopulacaoDTO;
import com.avalicao3.states.apirest.dto.RegiaoDTO;
import com.avalicao3.states.apirest.entities.State;
import com.avalicao3.states.apirest.repositories.StateRepository;
import com.avalicao3.states.apirest.services.exception.ObjNotFoundException;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repository;
	
	public List<State>findAll(){
		return repository.findAll();
	}
	public State findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new ObjNotFoundException("ID: " + id + " <- não foi encontrado"));
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
}