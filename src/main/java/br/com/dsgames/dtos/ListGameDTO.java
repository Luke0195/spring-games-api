package br.com.dsgames.dtos;

import br.com.dsgames.entities.GameList;

public class ListGameDTO {

    private Long id;
    private String name;

    public ListGameDTO(){};

    public ListGameDTO(GameList entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
