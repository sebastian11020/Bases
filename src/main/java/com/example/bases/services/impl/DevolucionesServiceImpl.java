package com.example.bases.services.impl;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Devoluciones;
import com.example.bases.repository.DevolucionesRepository;
import com.example.bases.services.DevolucionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucionesServiceImpl implements DevolucionesService {

    @Autowired
    private DevolucionesRepository devolucionesRepository;
    @Override
    public Devoluciones findByIdDevoluciones(int id) {
        return devolucionesRepository.findById(id).orElse(null);
    }
    @Override
    public List<Devoluciones> findAllDevoluciones() {
        return devolucionesRepository.findAll();
    }
    @Override
    public Devoluciones saveDevoluciones(Devoluciones devolucion) {
        return devolucionesRepository.save(devolucion) ;
    }
    @Override
    public Devoluciones updateDevoluciones(int id) {
        return devolucionesRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdDevoluciones(int id) {
        if(devolucionesRepository.existsById(id)){
            devolucionesRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
