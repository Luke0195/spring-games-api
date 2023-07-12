package br.com.dsgames.projections;

// pesquisar sobre projection
public interface GameListProjection {
    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
