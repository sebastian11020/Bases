package com.example.bases.controller;

import com.example.bases.models.entities.Devoluciones;
import com.example.bases.services.DevolucionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class DevolucionesController {

    @Autowired
    private DevolucionesService devolucionesService;

    @PostMapping
    public ResponseEntity<Devoluciones> saveDevoluciones(@Valid @RequestBody Devoluciones devolucion){
        return ResponseEntity.ok(devolucionesService.saveDevoluciones(devolucion));
    }

    @PostMapping
    public ResponseEntity<List<Devoluciones>> findAllDevoluciones() {
        List<Devoluciones> allDevoluciones = devolucionesService.findAllDevoluciones();

        if (allDevoluciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allDevoluciones);
        }
    }
    @PutMapping("/Devoluciones/updateDevoluciones/{id}")
    public ResponseEntity<Devoluciones> updateDevoluciones(@PathVariable int id, @Valid @RequestBody Devoluciones updatedDevolucion) {
        Devoluciones existingDevolucion = devolucionesService.findByIdDevoluciones(id);

        if (existingDevolucion == null) {
            return ResponseEntity.notFound().build();
        }

        existingDevolucion.setMotivo_devolucion(updatedDevolucion.getMotivo_devolucion());

        Devoluciones updatedDevolucionesEntity = devolucionesService.saveDevoluciones(existingDevolucion);
        return ResponseEntity.ok(updatedDevolucionesEntity);
    }
    @DeleteMapping("/Devoluciones/deleteByIdDevoluciones/{id}")
    public ResponseEntity<?> deleteByIdDevoluciones(@PathVariable Integer id){
        return devolucionesService.deleteByIdDevoluciones(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/Devoluciones/findByIdDevoluciones/{id}")
    public ResponseEntity<Devoluciones> findByIdDevoluciones(@PathVariable int id) {
        return ResponseEntity.ok(devolucionesService.findByIdDevoluciones(id));
    }
}
