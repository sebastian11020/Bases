package com.example.bases.services;
import com.example.bases.models.entities.Devoluciones;

import java.util.List;

public interface DevolucionesService {
    public Devoluciones findByIdDevoluciones(int id);
    public List<Devoluciones> findAllDevoluciones();
    public Devoluciones saveDevoluciones(Devoluciones devoluciones);
    public Devoluciones updateDevoluciones(int id);
    public boolean deleteByIdDevoluciones(int id);
}
