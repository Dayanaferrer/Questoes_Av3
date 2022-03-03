package com.avalicao3.states.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.avalicao3.states.entities.States;
import com.avalicao3.states.repositories.StatesRepository;

//classe para popular o bando de dados com alguns objetos.

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private StatesRepository statesRepository;

	@Override
	public void run(String... args) throws Exception { //Tudo que for colocado aqui vai ser executado quando a aplicacao for iniciada.
		
		States estado1 = new States(null, "Pernambuco", "Nordeste", 9674793L, "Recife", 98.312);
		States estado2 = new States (null, "Amazonas", "Norte", 4269995L, "Manaus", 1.571000);
		States estado3 = new States (null, "Santa Catarina", "Sul", 95346L, "Florianópolis", 7.338473);
		States estado4 = new States (null, "Minas Gerais", "Sudeste", 586528L, "Belo Horizonte",21.411923);
		States estado5 = new States (null, "Distrito Federal", "Centro-Oeste", 3094325L, "Brasília",5.761000 );
		
		statesRepository.saveAll(Arrays.asList(estado1,estado2,estado3,estado4,estado5));
	}
		

}
