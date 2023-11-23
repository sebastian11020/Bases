package com.example.bases.services;
import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Empresas_Afiliadas;

import java.util.List;

public interface Empresas_AfiliadasService {
    public Empresas_Afiliadas findByIdEmpresas_Afiliadas(int id);
    public List<Empresas_Afiliadas> findAllEmpresas_Afiliadas();
    public Empresas_Afiliadas saveEmpresas_Afiliadas(Empresas_Afiliadas empresa_afiliada);
    public Empresas_Afiliadas updateEmpresas_Afiliadas(int id);
    public boolean deleteByIdEmpresas_Afiliadas(int id);
}
