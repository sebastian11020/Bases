package com.example.bases.controller;

import com.example.bases.models.entities.Detalles_Facturas;
import com.example.bases.services.Detalles_FacturasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bases")
public class Detalles_FacturasController {
    @Autowired
    private Detalles_FacturasService detalles_FacturasService;

    @PostMapping
    public ResponseEntity<Detalles_Facturas> savePersonas(@Valid @RequestBody Detalles_Facturas detalles_factura){
        return ResponseEntity.ok(detalles_FacturasService.saveDetalles_Facturas(detalles_factura));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Detalles_Facturas> updatePersonas(@PathVariable int id, @Valid @RequestBody Detalles_Facturas updatedDetallesFactura) {
        Detalles_Facturas existingDetalles_Facturas = detalles_FacturasService.findByIdDetalles_Facturas(id);

        if (existingDetalles_Facturas == null) {
            return ResponseEntity.notFound().build();
        }

        existingDetalles_Facturas.setCantidad_producto(updatedDetallesFactura.getCantidad_producto());

        Detalles_Facturas updatedDetallesFacturaEntity = detalles_FacturasService.saveDetalles_Facturas(existingDetalles_Facturas);
        return ResponseEntity.ok(updatedDetallesFacturaEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPersonas(@PathVariable Integer id){
        return detalles_FacturasService.deleteByIdDetalles_Facturas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Detalles_Facturas> findByIdPersonas(@PathVariable int id) {
        return ResponseEntity.ok(detalles_FacturasService.findByIdDetalles_Facturas(id));
    }
}
