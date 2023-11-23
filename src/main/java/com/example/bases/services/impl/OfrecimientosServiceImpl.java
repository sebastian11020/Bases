package com.example.bases.services.impl;

import com.example.bases.models.entities.Ofrecimientos;
import com.example.bases.repository.OfrecimientosRepository;
import com.example.bases.services.OfrecimientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfrecimientosServiceImpl implements OfrecimientosService {
    @Autowired
    private OfrecimientosRepository ofrecimientosRepository;
    @Override
    public Ofrecimientos findByIdOfrecimientos(int id) {
        return ofrecimientosRepository.findById(id).orElse(null);
    }
    @Override
    public List<Ofrecimientos> findAllOfrecimientos() {
        return ofrecimientosRepository.findAll();
    }
    @Override
    public Ofrecimientos saveOfrecimientos(Ofrecimientos ofrecimientos) {
        return ofrecimientosRepository.save(ofrecimientos) ;
    }
    @Override
    public Ofrecimientos updateOfrecimientos(int id) {
        return ofrecimientosRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdOfrecimientos(int id) {
        if(ofrecimientosRepository.existsById(id)){
            ofrecimientosRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
