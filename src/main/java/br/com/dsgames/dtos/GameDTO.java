package br.com.dsgames.dtos;

import br.com.dsgames.entities.Game;

import java.io.Serial;
import java.io.Serializable;

public class GameDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDTO(){};

    public GameDTO(Long id, String title, Integer year, String imgUrl, String shortDescription){
        this.id = id;
        this.title = title;
        this.year = year;
        this.shortDescription = shortDescription;
    }

    public GameDTO(Game entity){
        this.id = entity.getId();
        this.year = entity.getYear();
        this.title = entity.getTitle();
        this.shortDescription = entity.getShortDescription();
        this.imgUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }


}
