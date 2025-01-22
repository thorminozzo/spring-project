package com.javaspring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.dslist.dto.GameDTO;
import com.javaspring.dslist.dto.GameListDTO;
import com.javaspring.dslist.dto.GameMinDTO;
import com.javaspring.dslist.services.GameListService;
import com.javaspring.dslist.services.GameService;

@RestController
@RequestMapping( value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> listGame = gameListService.findAll();
		return listGame;
	}

}