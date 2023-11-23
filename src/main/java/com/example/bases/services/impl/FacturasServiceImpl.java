package com.example.bases.services.impl;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Facturas;
import com.example.bases.repository.FacturasRepository;
import com.example.bases.services.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturasServiceImpl implements FacturasService {

    @Autowired
    private FacturasRepository facturasRepository;
    @Override
    public Facturas findByIdFacturas(int id) {
        return facturasRepository.findById(id).orElse(null);
    }
    @Override
    public List<Facturas> findAllFacturas() {
        return facturasRepository.findAll();
    }
    @Override
    public Facturas saveFacturas(Facturas factura) {
        return facturasRepository.save(factura) ;
    }
    @Override
    public Facturas updateFacturas(int id) {
        return facturasRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdFacturas(int id) {
        if(facturasRepository.existsById(id)){
            facturasRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
