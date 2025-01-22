package com.javaspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
