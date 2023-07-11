package br.com.dsgames.services;
import java.util.List;
import br.com.dsgames.dtos.GameDTO;
import br.com.dsgames.entities.Game;
import br.com.dsgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<GameDTO> findAllGames(){
        List<Game> games = repository.findAll();
        return  games.stream().map(GameDTO::new).toList();

    }



}
