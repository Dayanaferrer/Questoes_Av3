package com.avalicao3.states.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avalicao3.states.entities.States;

public interface StatesRepository extends JpaRepository<States, Long> {

}
