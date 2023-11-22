package com.example.bases.services.impl;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.repository.Detalles_FacturasRepository;
import com.example.bases.services.Detalles_FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detalles_FacturasServiceImpl implements Detalles_FacturasService {
    @Autowired
    private Detalles_FacturasRepository detalles_FacturasRepository;
    @Override
    public Detalles_Facturas findByIdDetalles_Facturas(int id){
        return detalles_FacturasRepository.findById(id).orElse(null);
    }
    @Override
    public Detalles_Facturas saveDetalles_Facturas(Detalles_Facturas detalles_facturas) {
        return detalles_FacturasRepository.save(detalles_facturas);
    }
    @Override
    public Detalles_Facturas updateDetalles_Facturas(int id) {
        return detalles_FacturasRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdDetalles_Facturas(int id) {
        if(detalles_FacturasRepository.existsById(id)){
            detalles_FacturasRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
