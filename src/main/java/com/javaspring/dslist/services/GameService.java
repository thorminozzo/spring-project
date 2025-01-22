package com.javaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.dslist.dto.GameMinDTO;
import com.javaspring.dslist.entities.Game;
import com.javaspring.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		List<Game> listGame = gameRepository.findAll();
		List<GameMinDTO> listGameDTO = listGame.stream().map(x -> new GameMinDTO(x)).toList();
		return listGameDTO;
	}
}
		