package br.com.dsgames.controllers;

import br.com.dsgames.dtos.GameDTO;
import br.com.dsgames.dtos.GameListDTO;
import br.com.dsgames.services.GameService;

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
    public ResponseEntity<List<GameListDTO>> findAll(){

        List<GameListDTO> dto = service.findAllGames();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@PathVariable Long id){
        GameDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
