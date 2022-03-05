package com.avalicao3.states.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalicao3.states.apirest.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
