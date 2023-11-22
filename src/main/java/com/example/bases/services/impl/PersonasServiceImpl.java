package com.example.bases.services.impl;

import com.example.bases.models.entities.Personas;
import com.example.bases.repository.PersonasRepository;
import com.example.bases.services.PersonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonasServiceImpl implements PersonasService {
    @Autowired
    private PersonasRepository personasRepository;
    @Override
    public Personas findByIdPersonas(int id) {
        return personasRepository.findById(id).orElse(null);
    }
    @Override
    public Personas savePersonas(Personas persona) {
        return personasRepository.save(persona) ;
    }
    @Override
    public Personas updatePersonas(int id) {
        return personasRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdPersonas(int id) {
        if(personasRepository.existsById(id)){
            personasRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
