package com.example.bases.services;
import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Facturas;

import java.util.List;

public interface FacturasService {
    public Facturas findByIdFacturas(int id);
    public List<Facturas> findAllFacturas();
    public Facturas saveFacturas(Facturas factura);
    public Facturas updateFacturas(int id);
    public boolean deleteByIdFacturas(int id);
}
