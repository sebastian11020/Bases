package com.example.bases.controller;

import com.example.bases.models.entities.Ofrecimientos;
import com.example.bases.services.OfrecimientosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class OfrecimientosController {
    @Autowired
    private OfrecimientosService ofrecimientosService;

    @PostMapping("/ofrecimientos/saveOfrecimientos")
    public ResponseEntity<Ofrecimientos> saveOfrecimientos(@Valid @RequestBody Ofrecimientos ofrecimientos){
        return ResponseEntity.ok(ofrecimientosService.saveOfrecimientos(ofrecimientos));
    }
    @PostMapping("/ofrecimientos/findAll")
    public ResponseEntity<List<Ofrecimientos>> findAllOfrecimientos() {
        List<Ofrecimientos> allOfrecimientos = ofrecimientosService.findAllOfrecimientos();

        if (allOfrecimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allOfrecimientos);
        }
    }

    @PutMapping("/Ofrecimientos/updateOfrecimientos/{id}")
    public ResponseEntity<Ofrecimientos> updateOfrecimientos(@PathVariable int id, @Valid @RequestBody Ofrecimientos updatedOfrecimientos) {
        Ofrecimientos existingOfrecimientos = ofrecimientosService.findByIdOfrecimientos(id);

        if (existingOfrecimientos == null) {
            return ResponseEntity.notFound().build();
        }

        existingOfrecimientos.setPrecio_ofrecimiento(updatedOfrecimientos.getPrecio_ofrecimiento());

        Ofrecimientos updatedPersonasEntity = ofrecimientosService.saveOfrecimientos(existingOfrecimientos);
        return ResponseEntity.ok(updatedPersonasEntity);
    }
    @DeleteMapping("/Ofrecimientos/deleteByIdOfrecimientos/{id}")
    public ResponseEntity<?> deleteByIdOfrecimientos(@PathVariable Integer id){
        return ofrecimientosService.deleteByIdOfrecimientos(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/Ofrecimientos/findByIdOfrecimientos/{id}")
    public ResponseEntity<Ofrecimientos> findByIdOfrecimientos(@PathVariable int id) {
        return ResponseEntity.ok(ofrecimientosService.findByIdOfrecimientos(id));
    }
}
