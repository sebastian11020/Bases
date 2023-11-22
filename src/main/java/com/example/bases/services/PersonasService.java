package com.example.bases.services;

import com.example.bases.models.entities.Personas;

public interface PersonasService{
    public Personas findByIdPersonas(int id);
    public Personas savePersonas(Personas persona);
    public Personas updatePersonas(int id);
    public boolean deleteByIdPersonas(int id);
}
