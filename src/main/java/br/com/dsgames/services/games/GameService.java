package br.com.dsgames.services.games;
import java.util.List;
import java.util.Optional;

import br.com.dsgames.dtos.games.GameDTO;
import br.com.dsgames.dtos.games.GameMinDTO;
import br.com.dsgames.entities.Game;
import br.com.dsgames.projections.GameMinProjection;
import br.com.dsgames.repositories.games.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    @Transactional(readOnly = true) // Vai permitir que as operações obedesão o modelo ACID
    public List<GameMinDTO> findAllGames(){
        List<Game> games = repository.findAll();
        return  games.stream().map(GameMinDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Optional<Game> entity = repository.findById(id);
        Game game = entity.get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = repository.searchByList(listId);
        System.out.println(result);
        return result.stream().map(GameMinDTO::new).toList();
    }



}
