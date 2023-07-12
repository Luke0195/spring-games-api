package br.com.dsgames.services;
import java.util.List;
import java.util.Optional;

import br.com.dsgames.dtos.GameDTO;
import br.com.dsgames.dtos.GameListDTO;
import br.com.dsgames.entities.Game;
import br.com.dsgames.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true) // Vai permitir que as operações obedesão o modelo ACID
    public List<GameListDTO> findAllGames(){
        List<Game> games = repository.findAll();
        return  games.stream().map(GameListDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Optional<Game> entity = repository.findById(id);
        Game game = entity.get();
        return new GameDTO(game);
    }


}
