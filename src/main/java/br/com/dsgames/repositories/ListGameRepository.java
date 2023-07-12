package br.com.dsgames.repositories;

import br.com.dsgames.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListGameRepository extends JpaRepository<GameList, Long> {
}
