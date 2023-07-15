package br.com.dsgames.controllers.games;

import br.com.dsgames.dtos.games.GameDTO;
import br.com.dsgames.dtos.games.GameMinDTO;
import br.com.dsgames.services.games.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService service;
    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll(){

        List<GameMinDTO> dto = service.findAllGames();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
        GameDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
