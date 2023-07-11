package br.com.dsgames.controllers;

import br.com.dsgames.dtos.GameDTO;
import br.com.dsgames.services.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {
    @Autowired
    private GameService service;
    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll(){

        List<GameDTO> dto = service.findAllGames();
        return ResponseEntity.ok().body(dto);
    }

}
