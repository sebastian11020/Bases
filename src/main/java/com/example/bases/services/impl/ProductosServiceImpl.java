package com.example.bases.services.impl;

import com.example.bases.models.entities.Productos;
import com.example.bases.repository.ProductosRepository;
import com.example.bases.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductosRepository productosRepositoryRepository;
    @Override
    public Productos findByIdProductos(int id) {
        return productosRepositoryRepository.findById(id).orElse(null);
    }
    @Override
    public List<Productos> findAllProductos() {
        return productosRepositoryRepository.findAll();
    }
    @Override
    public Productos saveProductos(Productos producto) {
        return productosRepositoryRepository.save(producto) ;
    }
    @Override
    public Productos updateProductos(int id) {
        return productosRepositoryRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdProductos(int id) {
        if(productosRepositoryRepository.existsById(id)){
            productosRepositoryRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Productos findByNombreProductos(String nombre) {
        return productosRepositoryRepository.findByNombre(nombre);
    }

    @Override
    public boolean deleteByNombreProductos(String nombre) {
        Productos producto = productosRepositoryRepository.findByNombre(nombre);
        if (producto != null) {
            productosRepositoryRepository.delete(producto);
            return true;
        }
        return false;
    }
}
