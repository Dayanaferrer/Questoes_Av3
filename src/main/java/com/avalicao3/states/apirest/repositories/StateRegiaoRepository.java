package com.avalicao3.states.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalicao3.states.apirest.entities.State;
import com.avalicao3.states.apirest.entities.StateRegiao;

public interface StateRegiaoRepository extends JpaRepository<StateRegiao, Long> {

}
