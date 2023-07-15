package br.com.dsgames.repositories.users;

import br.com.dsgames.dtos.users.UserLoginDTO;
import br.com.dsgames.entities.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, UUID> {
   @Query(nativeQuery = true, value = """
			SELECT tb_users.id from tb_users where tb_users.login = :login	""")


   public UserLogin findByLogin(String login);
}
