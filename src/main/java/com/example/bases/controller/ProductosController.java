package com.example.bases.controller;

import com.example.bases.models.entities.Productos;
import com.example.bases.services.ProductosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @PostMapping("/productos/saveProductos")
    public ResponseEntity<Productos> saveProductos(@Valid @RequestBody Productos producto){
        return ResponseEntity.ok(productosService.saveProductos(producto));
    }
    @PostMapping("/productos/findAll")
    public ResponseEntity<List<Productos>> findAllProductos() {
        List<Productos> allProductos = productosService.findAllProductos();

        if (allProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allProductos);
        }
    }

    @PutMapping("Productos/updateProductos/{id}")
    public ResponseEntity<Productos> updateProductos(@PathVariable int id, @Valid @RequestBody Productos updatedProductos) {
        Productos existingProductos = productosService.findByIdProductos(id);

        if (existingProductos == null) {
            return ResponseEntity.notFound().build();
        }

        existingProductos.setDescripcion_producto(updatedProductos.getDescripcion_producto());
        existingProductos.setNombre_producto(updatedProductos.getNombre_producto());
        existingProductos.setPrecio_venta_producto(updatedProductos.getPrecio_venta_producto());
        existingProductos.setFecha_vencimiento_producto(updatedProductos.getFecha_vencimiento_producto());

        Productos updatedProductosEntity = productosService.saveProductos(existingProductos);
        return ResponseEntity.ok(updatedProductosEntity);
    }
    @DeleteMapping("Productos/deleteByNombreProductos/{id}")
    public ResponseEntity<?> deleteByIdProductos(@PathVariable Integer id){
        return productosService.deleteByIdProductos(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("Productos/findByNombreProductos/{id}")
    public ResponseEntity<Productos> findByIdProductos(@PathVariable int id) {
        return ResponseEntity.ok(productosService.findByIdProductos(id));
    }
    /*@GetMapping("Productos/findByNombreProductos/{nombre}")
    public ResponseEntity<Productos> findByProductos(@PathVariable String nombre) {
        Productos empresa = productosService.findByNombreProductos(nombre);

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(empresa);
        }
    }
    @DeleteMapping("Productos/deleteByNombreProductos/{nombre}")
    public ResponseEntity<?> deleteByNombreProductos(@PathVariable String nombre) {
        boolean deleted = productosService.deleteByNombreProductos(nombre);
        if (deleted) {
            return ResponseEntity.ok("Eliminado Correctamente, nombre: " + nombre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
