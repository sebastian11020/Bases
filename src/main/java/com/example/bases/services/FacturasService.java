package com.example.bases.services;
import com.example.bases.models.entities.Facturas;
public interface FacturasService {
    public Facturas findByIdFacturas(int id);
    public Facturas saveFacturas(Facturas factura);
    public Facturas updateFacturas(int id);
    public boolean deleteByIdFacturas(int id);
}
