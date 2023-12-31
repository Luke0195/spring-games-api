package br.com.dsgames.dtos.games;

import br.com.dsgames.entities.Game;
import br.com.dsgames.projections.GameMinProjection;

import java.io.Serial;
import java.io.Serializable;

public class GameMinDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(){};

    public GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription){
        this.id = id;
        this.title = title;
        this.year = year;
        this.shortDescription = shortDescription;
    }

    public GameMinDTO(Game entity){
        this.id = entity.getId();
        this.year = entity.getYear();
        this.title = entity.getTitle();
        this.shortDescription = entity.getShortDescription();
        this.imgUrl = entity.getImgUrl();
    }

    public GameMinDTO(GameMinProjection entity){
        // O bean é uma forma de gerenciar o a copia de muita propriedades sem ter que ficar repassando cada um dos métodos
        this.id = entity.getId();
        this.year = entity.getGameYear();
        this.title = entity.getTitle();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
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
