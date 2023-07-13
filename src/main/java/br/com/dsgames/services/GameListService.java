package br.com.dsgames.services;

import br.com.dsgames.dtos.GameMinDTO;
import br.com.dsgames.dtos.ListGameDTO;
import br.com.dsgames.entities.GameList;
import br.com.dsgames.projections.GameMinProjection;
import br.com.dsgames.repositories.GameListRepository;
import br.com.dsgames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<ListGameDTO> findAll(){
        List<GameList> list = repository.findAll();
        return list.stream().map(ListGameDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }
}
