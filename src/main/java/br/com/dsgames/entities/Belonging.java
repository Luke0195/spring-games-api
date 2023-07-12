package br.com.dsgames.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Table
@Entity(name = "tb_belonging")
public class Belonging implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private final BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging(){}

    public Belonging(Game game, GameList list, Integer position){
        this.id.setGame(game);
        this.id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
