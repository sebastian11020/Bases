package com.example.bases.repository;

import com.example.bases.models.entities.Detalles_Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalles_FacturasRepository extends JpaRepository<Detalles_Facturas, Integer> {
}
