package com.example.bases.services;

import com.example.bases.models.entities.Productos;

import java.util.List;

public interface ProductosService {
    public Productos findByIdProductos(int id);
    public List<Productos> findAllProductos();
    public Productos saveProductos(Productos producto);
    public Productos updateProductos(int id);
    public boolean deleteByIdProductos(int id);
    /*Productos findByNombreProductos(String nombre);
    boolean deleteByNombreProductos(String nombre);*/
}
