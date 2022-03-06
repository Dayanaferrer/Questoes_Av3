package com.avaliacao3.states.apirest.dto;

import java.io.Serializable;

import com.avaliacao3.states.apirest.entities.State;

public class PopulacaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Long populacao;
	
	public PopulacaoDTO () {		
	}
	
	public PopulacaoDTO (State obj) {
		id = obj.getId();
		nome = obj.getNome();
		populacao = obj.getPopulacao();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

}
