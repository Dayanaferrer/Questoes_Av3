package com.avaliacao3.states.apirest.dto;

import java.io.Serializable;

import com.avaliacao3.states.apirest.entities.State;

public class RegiaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	
	public RegiaoDTO() {		
	}
	
	public RegiaoDTO (State obj) {
		id = obj.getId();
		nome = obj.getNome();	
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

	
}
