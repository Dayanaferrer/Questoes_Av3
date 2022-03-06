package com.avaliacao3.states.apirest.dto;

import java.io.Serializable;

import com.avaliacao3.states.apirest.entities.State;

public class AreaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private Double area;
	
	public AreaDTO () {	
	}
	
	public AreaDTO (State obj) {
		id = obj.getId();
		nome = obj.getNome();
		area = obj.getArea();		
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

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}
	
}

