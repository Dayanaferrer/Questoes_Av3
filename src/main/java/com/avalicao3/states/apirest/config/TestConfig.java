package com.avalicao3.states.apirest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.avalicao3.states.apirest.entities.State;
import com.avalicao3.states.apirest.repositories.StateRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public void run(String... args) throws Exception {
						
		State estado1 = new State(null, "Pernambuco", "Nordeste", 9674793L, "Recife", 98.312000);
		State estado2 = new State (null, "Amazonas", "Norte", 4269995L, "Manaus", 1.571000);
		State estado3 = new State (null, "Santa Catarina", "Sul", 95346L, "Florianópolis", 7.338473);
		State estado4 = new State (null, "Minas Gerais", "Sudeste", 586528L, "Belo Horizonte",21.411923);
		State estado5 = new State (null, "Distrito Federal", "Centro-Oeste", 3094325L, "Brasília",5.761000 );
		
		stateRepository.saveAll(Arrays.asList(estado1,estado2,estado3,estado4,estado5));
	}

}
