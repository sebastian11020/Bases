package com.example.bases.services.impl;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Empresas_Afiliadas;
import com.example.bases.repository.Empresas_AfiliadasRepository;
import com.example.bases.services.Empresas_AfiliadasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Empresas_AfiliadasServiceImpl implements Empresas_AfiliadasService{
    @Autowired
    private Empresas_AfiliadasRepository empresas_afiliadasRepository;
    @Override
    public Empresas_Afiliadas findByIdEmpresas_Afiliadas(int id) {
        return empresas_afiliadasRepository.findById(id).orElse(null);
    }
    @Override
    public List<Empresas_Afiliadas> findAllEmpresas_Afiliadas() {
        return empresas_afiliadasRepository.findAll();
    }
    @Override
    public Empresas_Afiliadas saveEmpresas_Afiliadas(Empresas_Afiliadas empresa_afiliada) {
        return empresas_afiliadasRepository.save(empresa_afiliada) ;
    }
    @Override
    public Empresas_Afiliadas updateEmpresas_Afiliadas(int id) {
        return empresas_afiliadasRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdEmpresas_Afiliadas(int id) {
        if(empresas_afiliadasRepository.existsById(id)){
            empresas_afiliadasRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
