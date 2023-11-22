package com.example.bases.services;

import com.example.bases.models.entities.Personas;

import java.util.List;

public interface PersonasService {
    public Personas findByIdPersons (int id);
    public Personas savePersonas(Personas persona);
    public int updatePersonas(Personas persona);
    public boolean deleteByIdPersonas(int id);
}
