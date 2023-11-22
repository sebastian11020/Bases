package com.example.bases.controller;

import com.example.bases.models.entities.Devoluciones;
import com.example.bases.models.entities.Personas;
import com.example.bases.services.DevolucionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bases")
public class DevolucionesController {

    @Autowired
    private DevolucionesService devolucionesService;

    @PostMapping
    public ResponseEntity<Devoluciones> saveDevoluciones(@Valid @RequestBody Devoluciones devolucion){
        return ResponseEntity.ok(devolucionesService.saveDevoluciones(devolucion));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Devoluciones> updateDevoluciones(@PathVariable int id, @Valid @RequestBody Devoluciones updatedDevolucion) {
        Devoluciones existingDevolucion = devolucionesService.findByIdDevoluciones(id);

        if (existingDevolucion == null) {
            return ResponseEntity.notFound().build();
        }

        existingDevolucion.setMotivo_devolucion(updatedDevolucion.getMotivo_devolucion());

        Devoluciones updatedDevolucionesEntity = devolucionesService.saveDevoluciones(existingDevolucion);
        return ResponseEntity.ok(updatedDevolucionesEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPersonas(@PathVariable Integer id){
        return devolucionesService.deleteByIdDevoluciones(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Devoluciones> findByIdDevoluciones(@PathVariable int id) {
        return ResponseEntity.ok(devolucionesService.findByIdDevoluciones(id));
    }
}
