package com.javaspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
