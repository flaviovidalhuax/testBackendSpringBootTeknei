package com.example.demo.service;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;

import java.util.List;
import java.util.Optional;

public interface UsuarioService{

    List<Persona> getAllUser();

    Optional<Persona> getById(Integer id);
    

    Persona updateUser(Integer id, Persona persona);

    void deleteUser(Long id);

    String createUser(PersonaDTO personaDTO);
}
