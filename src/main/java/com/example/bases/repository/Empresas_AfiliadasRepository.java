package com.example.bases.repository;

import com.example.bases.models.entities.Empresas_Afiliadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Empresas_AfiliadasRepository extends JpaRepository<Empresas_Afiliadas, Integer> {
    Empresas_Afiliadas findByNombre(String nombre);
}
