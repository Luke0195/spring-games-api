package br.com.dsgames.dtos.users;

import br.com.dsgames.entities.UserLogin;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class UserLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String name;
    private String email;
    private String login;

    public UserLoginDTO(){};

    public UserLoginDTO(UUID id, String name, String email, String login){
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
    }

    public UserLoginDTO(UserLogin entity){
        BeanUtils.copyProperties(entity, this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
