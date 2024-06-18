package com.example.demo.controller;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuiarioCotrroller {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/allUser")
    public ResponseEntity<List<Persona>> allUSer2(){
         List<Persona> data=usuarioService.getAllUser();
        return  ResponseEntity.status(HttpStatus.OK).body(data);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Persona>>  userById(@PathVariable Integer id){
        Optional<Persona> user=usuarioService.getById(id);
        if(user.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody PersonaDTO personaDTO) {
        String user = usuarioService.createUser(personaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Persona> updateUser(@PathVariable Integer id, @RequestBody Persona persona) {
        Persona updatedUser = usuarioService.updateUser(id, persona);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
