package com.javaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspring.dslist.dto.GameDTO;
import com.javaspring.dslist.dto.GameMinDTO;
import com.javaspring.dslist.entities.Game;
import com.javaspring.dslist.projections.GameMinProjection;
import com.javaspring.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> listGameDTO = result.stream().map(x -> new GameMinDTO(x)).toList();
		return listGameDTO;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList(); 
		
	}
		
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game listGame = gameRepository.findById(id).get();
		GameDTO listGameDTO = new GameDTO(listGame);
		return listGameDTO;
	}
}
		