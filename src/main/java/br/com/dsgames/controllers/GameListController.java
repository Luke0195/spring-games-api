package br.com.dsgames.controllers;

import br.com.dsgames.dtos.GameListDTO;
import br.com.dsgames.dtos.ListGameDTO;
import br.com.dsgames.services.GameService;
import br.com.dsgames.services.ListGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/lists")
public class GameListController {
    @Autowired
    private ListGameService service;
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<ListGameDTO>> findAllGames(){
        List<ListGameDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{listId}/games")
     public ResponseEntity<List<GameListDTO>> findGamesListById(@PathVariable Long listId){
        List<GameListDTO> list = gameService.findByList(listId);
        return ResponseEntity.ok().body(list);
    }

}
