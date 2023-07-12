package br.com.dsgames.services;

import br.com.dsgames.dtos.ListGameDTO;
import br.com.dsgames.entities.GameList;
import br.com.dsgames.repositories.ListGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListGameService {
    @Autowired
    private ListGameRepository repository;

    @Transactional(readOnly = true)
    public List<ListGameDTO> findAll(){
        List<GameList> list = repository.findAll();
        return list.stream().map(ListGameDTO::new).toList();
    }
}
