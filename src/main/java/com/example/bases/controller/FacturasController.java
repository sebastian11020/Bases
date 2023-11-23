package com.example.bases.controller;

import com.example.bases.models.entities.Facturas;
import com.example.bases.services.FacturasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Bases")
public class FacturasController {

    @Autowired
    private FacturasService facturasService;

    @PostMapping
    public ResponseEntity<Facturas> savePersonas(@Valid @RequestBody Facturas facturas){
        return ResponseEntity.ok(facturasService.saveFacturas(facturas));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Facturas> updatePersonas(@PathVariable int id, @Valid @RequestBody Facturas updatedFactura) {
        Facturas existingFactura = facturasService.findByIdFacturas(id);

        if (existingFactura == null) {
            return ResponseEntity.notFound().build();
        }

        existingFactura.setFecha_factura(updatedFactura.getFecha_factura());
        existingFactura.setPrecio_producto_factura(updatedFactura.getPrecio_producto_factura());
        existingFactura.setTipo_factura(updatedFactura.getTipo_factura());
        existingFactura.setSi_pago(updatedFactura.isSi_pago());

        Facturas updatedFacturasEntity = facturasService.saveFacturas(existingFactura);
        return ResponseEntity.ok(updatedFacturasEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPersonas(@PathVariable Integer id){
        return facturasService.deleteByIdFacturas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Facturas> findByIdPersonas(@PathVariable int id) {
        return ResponseEntity.ok(facturasService.findByIdFacturas(id));
    }
}
