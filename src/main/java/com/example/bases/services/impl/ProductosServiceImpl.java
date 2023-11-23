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
    private ProductosRepository productosRepository;
    @Override
    public Productos findByIdProductos(int id) {
        return productosRepository.findById(id).orElse(null);
    }
    @Override
    public List<Productos> findAllProductos() {
        return productosRepository.findAll();
    }
    @Override
    public Productos saveProductos(Productos producto) {
        return productosRepository.save(producto) ;
    }
    @Override
    public Productos updateProductos(int id) {
        return productosRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteByIdProductos(int id) {
        if(productosRepository.existsById(id)){
            productosRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    /*@Override
    public Productos findByNombreProductos(String nombre) {
        return productosRepository.findByNombre(nombre);
    }

    @Override
    public boolean deleteByNombreProductos(String nombre) {
        Productos producto = productosRepository.findByNombre(nombre);
        if (producto != null) {
            productosRepository.delete(producto);
            return true;
        }
        return false;
    }*/
}
