package com.example.bases.controller;

import com.example.bases.models.entities.Personas;
import com.example.bases.services.PersonasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class PersonasController {

    @Autowired
    private PersonasService personasService;

    @PostMapping("/personas/savePersonas")
    public ResponseEntity<Personas> savePersonas(@Valid @RequestBody Personas persona){
        return ResponseEntity.ok(personasService.savePersonas(persona));
    }
    @PostMapping("/personas/findAll")
    public ResponseEntity<List<Personas>> findAllPersonas() {
        List<Personas> allPersonas = personasService.findAllPersonas();

        if (allPersonas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allPersonas);
        }
    }
    @PutMapping("Personas/updatePersonas/{id}")
    public ResponseEntity<Personas> updatePersonas(@PathVariable int id, @Valid @RequestBody Personas updatedPersona) {
        Personas existingPersona = personasService.findByIdPersonas(id);

        if (existingPersona == null) {
            return ResponseEntity.notFound().build();
        }

        existingPersona.setNombre(updatedPersona.getNombre());
        existingPersona.setNumero_contacto(updatedPersona.getNumero_contacto());

        Personas updatedPersonasEntity = personasService.savePersonas(existingPersona);
        return ResponseEntity.ok(updatedPersonasEntity);
    }
    @DeleteMapping("Personas/deleteByIdPersonas/{id}")
    public ResponseEntity<?> deleteByIdPersonas(@PathVariable Integer id){
        return personasService.deleteByIdPersonas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("Personas/findByNombrePersonas/{id}")
    public ResponseEntity<Personas> findByIdPersonas(@PathVariable int id) {
        return ResponseEntity.ok(personasService.findByIdPersonas(id));
    }
    @GetMapping("Personas/findByNombrePersonas/{nombre}")
    public ResponseEntity<Personas> findByNombre(@PathVariable String nombre) {
        Personas empresa = personasService.findByNombrePersonas(nombre);

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(empresa);
        }
    }
    @DeleteMapping("Personas/deleteByNombrePersonas/{nombre}")
    public ResponseEntity<?> deleteByNombre(@PathVariable String nombre) {
        boolean deleted = personasService.deleteByNombrePersonas(nombre);

        if (deleted) {
            return ResponseEntity.ok("Eliminado Correctamente, nombre: " + nombre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
