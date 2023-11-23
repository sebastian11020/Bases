package com.example.bases.repository;

import com.example.bases.models.entities.Ofrecimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfrecimientosRepository extends JpaRepository<Ofrecimientos, Integer> {
}
