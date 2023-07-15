package br.com.dsgames.repositories.users;

import br.com.dsgames.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, UUID> {
}
