package com.javaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspring.dslist.dto.GameDTO;
import com.javaspring.dslist.dto.GameListDTO;
import com.javaspring.dslist.dto.GameMinDTO;
import com.javaspring.dslist.entities.Game;
import com.javaspring.dslist.entities.GameList;
import com.javaspring.dslist.repositories.GameListRepository;
import com.javaspring.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> listGame = gameListRepository.findAll();
		return listGame.stream().map(x -> new GameListDTO(x)).toList();
		
	}
	
}
