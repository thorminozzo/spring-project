package com.javaspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspring.dslist.dto.GameListDTO;

import com.javaspring.dslist.entities.GameList;
import com.javaspring.dslist.projections.GameMinProjection;
import com.javaspring.dslist.repositories.GameListRepository;
import com.javaspring.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> listGame = gameListRepository.findAll();
		return listGame.stream().map(x -> new GameListDTO(x)).toList();

	}

	@Transactional
	public void move(Long listId, int sourceIndex, int finalIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);

		list.add(finalIndex, obj);

		int min = sourceIndex < finalIndex ? sourceIndex : finalIndex;
		int max = sourceIndex < finalIndex ? finalIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
