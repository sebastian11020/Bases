package com.example.bases.repository;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.models.entities.Devoluciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionesRepository extends JpaRepository<Devoluciones, Integer> {
}
