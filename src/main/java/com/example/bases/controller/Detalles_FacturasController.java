package com.example.bases.controller;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.services.Detalles_FacturasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class Detalles_FacturasController {
    @Autowired
    private Detalles_FacturasService detalles_FacturasService;
    @PostMapping
    public ResponseEntity<List<Detalles_Facturas>> findAllDetallesFacturas() {
        List<Detalles_Facturas> allDetallesFacturas = detalles_FacturasService.findAllDetalles_Facturas();

        if (allDetallesFacturas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allDetallesFacturas);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Detalles_Facturas> updateDetalles_Facturas(@PathVariable int id, @Valid @RequestBody Detalles_Facturas updatedDetallesFactura) {
        Detalles_Facturas existingDetalles_Facturas = detalles_FacturasService.findByIdDetalles_Facturas(id);

        if (existingDetalles_Facturas == null) {
            return ResponseEntity.notFound().build();
        }

        existingDetalles_Facturas.setCantidad_producto(updatedDetallesFactura.getCantidad_producto());

        Detalles_Facturas updatedDetallesFacturaEntity = detalles_FacturasService.saveDetalles_Facturas(existingDetalles_Facturas);
        return ResponseEntity.ok(updatedDetallesFacturaEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdDetalles_Facturas(@PathVariable Integer id){
        return detalles_FacturasService.deleteByIdDetalles_Facturas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Detalles_Facturas> findByIdDetallesFacturas(@PathVariable int id) {
        return ResponseEntity.ok(detalles_FacturasService.findByIdDetalles_Facturas(id));
    }
}
