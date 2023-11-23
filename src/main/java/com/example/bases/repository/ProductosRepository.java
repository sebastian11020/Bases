package com.example.bases.repository;

import com.example.bases.models.entities.Empresas_Afiliadas;
import com.example.bases.models.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {
    Productos findByNombre(String nombre);
}
