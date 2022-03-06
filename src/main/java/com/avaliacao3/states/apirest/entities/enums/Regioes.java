package com.avaliacao3.states.apirest.entities.enums;

public enum Regioes {
	
	NORTE("Norte"),
	NORDESTE("Nordeste"),
	SUL("Sul"),
	SUDESTE("Sudeste"),
	CENTRO_OESTE("Centro_Oeste");
	
	private String campoRegiao;
	
	private Regioes(String campoRegiao) {
		this.campoRegiao = campoRegiao;
	}
	
	public String getcampoRegiao() {
		return campoRegiao;
	}
	
	public static Regioes getEnum(String campoRegiao) {
		for (Regioes value : Regioes.values()) {
			if (value.getcampoRegiao() == campoRegiao) {
				return value;
			}
		}
		throw new IllegalArgumentException("Região invalida!!! Insira uma das 5 regiões válidas.");
	}
}

