package com.example.bases.services;

import com.example.bases.models.entities.Ofrecimientos;

import java.util.List;

public interface OfrecimientosService {
    public Ofrecimientos findByIdOfrecimientos(int id);
    public List<Ofrecimientos> findAllOfrecimientos();
    public Ofrecimientos saveOfrecimientos(Ofrecimientos ofrecimiento);
    public Ofrecimientos updateOfrecimientos(int id);
    public boolean deleteByIdOfrecimientos(int id);
}
