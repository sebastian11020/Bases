package com.example.bases.repository;

import com.example.bases.models.entities.Facturas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FacturasRepository extends JpaRepository<Facturas, Integer> {
}
