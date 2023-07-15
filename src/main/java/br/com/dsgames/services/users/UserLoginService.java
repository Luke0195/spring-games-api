package br.com.dsgames.services.users;

import br.com.dsgames.dtos.users.UserLoginDTO;
import br.com.dsgames.entities.UserLogin;
import br.com.dsgames.repositories.users.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserLoginService {
    @Autowired
    private UserLoginRepository repository;


    public UserLoginDTO insert(UserLoginDTO dto){
        UserLogin login = new UserLogin();
        parsedDTOtoEntity(dto, login);
        login = repository.save(login);
        return new UserLoginDTO(login);
    }

    @Transactional(readOnly = true)

    public List<UserLoginDTO> findAll(){
      List<UserLogin> list = repository.findAll();
      return list.stream().map(x -> new UserLoginDTO(x)).toList();
    }

    private static void parsedDTOtoEntity(UserLoginDTO dto, UserLogin login){
        login.setLogin(dto.getLogin());
        login.setEmail(dto.getEmail());
        login.setName(dto.getName());
    }
}
