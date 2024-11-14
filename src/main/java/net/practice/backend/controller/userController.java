package net.practice.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.practice.backend.dto.userDTO;
import net.practice.backend.service.userService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userService service;

    @GetMapping
    public ResponseEntity<List<userDTO>> findAllUser(){
        List<userDTO> users = service.findAllUser();
        return ResponseEntity.ok(users);
    }


    @GetMapping("{id}")
    public ResponseEntity<userDTO> findByIdUser(@PathVariable(name="id") Long id){
        userDTO userFound = service.findUser(id);
        return ResponseEntity.ok(userFound);
    }

    @PostMapping("/agregar")
    public ResponseEntity<userDTO> createUser(@RequestBody userDTO userDTO){
        userDTO saveUser = service.createUser(userDTO);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<userDTO> updateUser(@PathVariable(name="id")Long id, @RequestBody userDTO userDTO){
        userDTO userUpdate = service.updateUser(id, userDTO);
        return ResponseEntity.ok(userUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(Long id){
        service.deleteUser(id);
        return ResponseEntity.ok("usuario eliminado");
    }

}
