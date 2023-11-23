package com.example.bases.controller;

import com.example.bases.models.entities.Empresas_Afiliadas;
import com.example.bases.services.Empresas_AfiliadasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Bases")
public class Empresas_AfiliadasController {
    @Autowired
    private Empresas_AfiliadasService empresas_afiliadas_service;

    @PostMapping
    public ResponseEntity<Empresas_Afiliadas> saveEmpresas_Afiliadas(@Valid @RequestBody Empresas_Afiliadas empresa_afiliada){
        return ResponseEntity.ok(empresas_afiliadas_service.saveEmpresas_Afiliadas(empresa_afiliada));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Empresas_Afiliadas> updatePersonas(@PathVariable int id, @Valid @RequestBody Empresas_Afiliadas updatedEmpresa_Afiliada) {
        Empresas_Afiliadas existingEmpresa_Afiliada = empresas_afiliadas_service.findByIdEmpresas_Afiliadas(id);

        if (existingEmpresa_Afiliada == null) {
            return ResponseEntity.notFound().build();
        }

        existingEmpresa_Afiliada.setNombre(updatedEmpresa_Afiliada.getNombre());

        Empresas_Afiliadas updatedPersonasEntity = empresas_afiliadas_service.saveEmpresas_Afiliadas(existingEmpresa_Afiliada);
        return ResponseEntity.ok(updatedPersonasEntity);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByIdPersonas(@PathVariable Integer id){
        return empresas_afiliadas_service.deleteByIdEmpresas_Afiliadas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empresas_Afiliadas> findByIdPersonas(@PathVariable int id) {
        return ResponseEntity.ok(empresas_afiliadas_service.findByIdEmpresas_Afiliadas(id));
    }
}
