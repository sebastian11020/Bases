package com.example.bases.services;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Personas;

import java.util.List;

public interface PersonasService{
    public Personas findByIdPersonas(int id);
    public List<Personas> findAllPersonas();
    public Personas savePersonas(Personas persona);
    public Personas updatePersonas(int id);
    public boolean deleteByIdPersonas(int id);
}
