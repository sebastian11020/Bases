package com.example.bases.services;
import com.example.bases.models.entities.Detalles_Facturas;
public interface Detalles_FacturasService {

    public Detalles_Facturas findByIdDetalles_Facturas(int id);
    public Detalles_Facturas saveDetalles_Facturas(Detalles_Facturas detalles_facturas);
    public Detalles_Facturas updateDetalles_Facturas(int id);
    public boolean deleteByIdDetalles_Facturas(int id);
}
