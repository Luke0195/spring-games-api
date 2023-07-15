package br.com.dsgames.controllers.games;

import br.com.dsgames.dtos.games.GameMinDTO;
import br.com.dsgames.dtos.games.ListGameDTO;
import br.com.dsgames.services.games.GameService;
import br.com.dsgames.services.games.GameListService;
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
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<ListGameDTO>> findAllGames(){
        List<ListGameDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }




}
