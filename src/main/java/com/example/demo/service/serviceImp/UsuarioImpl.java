package com.example.demo.service.serviceImp;

import com.example.demo.DTO.PersonaDTO;
import com.example.demo.entity.Persona;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioImpl implements UsuarioService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Persona> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public Optional<Persona> getById(Integer id) {
        return userRepository.findById(Long.valueOf(id));
    }


    @Override
    public Persona updateUser(Integer id, Persona persona) {
        Optional<Persona> inf=userRepository.findById(Long.valueOf(id));
        if (inf.isPresent()){
            Persona alumn=new Persona();
            alumn.setId(persona.getId());
            alumn.setNombreCompleto(persona.getNombreCompleto());
            alumn.setEdad(persona.getEdad());
           return userRepository.save(alumn);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String createUser(PersonaDTO personaDTO) {

        // Incrementar la edad en 1
        personaDTO.setEdad(personaDTO.getEdad() + 1);
        String name=personaDTO.getNombreCompleto();
        Integer edad=personaDTO.getEdad();
        // Convertir el DTO a la entidad
        Persona persona = new Persona();
        persona.setNombreCompleto(personaDTO.getNombreCompleto());
        persona.setEdad(personaDTO.getEdad());
        userRepository.save(persona);
        return "El nombre es " + name + " y la edad es " + edad;

    }
}
