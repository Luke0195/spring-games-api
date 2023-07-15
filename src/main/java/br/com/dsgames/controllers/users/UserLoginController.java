package br.com.dsgames.controllers.users;

import br.com.dsgames.dtos.users.UserLoginDTO;
import br.com.dsgames.services.users.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
public class UserLoginController {
    @Autowired
    private UserLoginService service;


    @PostMapping(value = "/users")
    public ResponseEntity<UserLoginDTO> create(@RequestBody UserLoginDTO userLoginDTO){
        UserLoginDTO dto = service.insert(userLoginDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(String.valueOf(userLoginDTO.getId())).buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(location).body(dto);
    }


    @GetMapping(value = "/users")
    public ResponseEntity<List<UserLoginDTO>> findAll(){
        List<UserLoginDTO> loginList = service.findAll();
        return ResponseEntity.ok(loginList);
    }

}
