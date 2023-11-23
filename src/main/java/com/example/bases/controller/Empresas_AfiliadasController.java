package com.example.bases.controller;

import com.example.bases.models.entities.Empresas_Afiliadas;
import com.example.bases.services.Empresas_AfiliadasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Bases")
public class Empresas_AfiliadasController {
    @Autowired
    private Empresas_AfiliadasService empresas_afiliadas_service;

    @PostMapping("/empresas_afiliadas/saveEmpresas_Afiliadas")
    public ResponseEntity<Empresas_Afiliadas> saveEmpresas_Afiliadas(@Valid @RequestBody Empresas_Afiliadas empresa_afiliada){
        return ResponseEntity.ok(empresas_afiliadas_service.saveEmpresas_Afiliadas(empresa_afiliada));
    }
    @PostMapping("/empresas_afiliadas/findAll")
    public ResponseEntity<List<Empresas_Afiliadas>> findAllEmpresas_Afiliadas() {
        List<Empresas_Afiliadas> allEmpresas_Afiliadas = empresas_afiliadas_service.findAllEmpresas_Afiliadas();

        if (allEmpresas_Afiliadas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(allEmpresas_Afiliadas);
        }
    }

    @PutMapping("/Empresas_Afiliadas/updateEmpresas_Afiliadas/{id}")
    public ResponseEntity<Empresas_Afiliadas> updateEmpresas_Afiliadas(@PathVariable int id, @Valid @RequestBody Empresas_Afiliadas updatedEmpresa_Afiliada) {
        Empresas_Afiliadas existingEmpresa_Afiliada = empresas_afiliadas_service.findByIdEmpresas_Afiliadas(id);

        if (existingEmpresa_Afiliada == null) {
            return ResponseEntity.notFound().build();
        }

        existingEmpresa_Afiliada.setNombre(updatedEmpresa_Afiliada.getNombre());

        Empresas_Afiliadas updatedPersonasEntity = empresas_afiliadas_service.saveEmpresas_Afiliadas(existingEmpresa_Afiliada);
        return ResponseEntity.ok(updatedPersonasEntity);
    }
    @DeleteMapping("/Empresas_Afiliadas/deleteByIdEmpresas_Afiliadas/{id}")
    public ResponseEntity<?> deleteByIdEmpresas_Afiliadas(@PathVariable Integer id){
        return empresas_afiliadas_service.deleteByIdEmpresas_Afiliadas(id)? ResponseEntity.ok("Eliminado Correctamente, id: "+id)
                :ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Empresas_Afiliadas> findByIdEmpresas_Afiliadas(@PathVariable int id) {
        return ResponseEntity.ok(empresas_afiliadas_service.findByIdEmpresas_Afiliadas(id));
    }
    @GetMapping("/Empresas_Afiliadas/findByNombreEmpresas_Afiliadas/{nombre}")
    public ResponseEntity<Empresas_Afiliadas> findByNombreEmpresas_Afiliadas(@PathVariable String nombre) {
        Empresas_Afiliadas empresa = empresas_afiliadas_service.findByNombreEmpresasAfiliadas(nombre);

        if (empresa == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(empresa);
        }
    }

    @DeleteMapping("/Empresas_Afiliadas/deleteByNombreEmpresas_Afiliadas/{nombre}")
    public ResponseEntity<?> deleteByNombreEmpresas_Afiliadas(@PathVariable String nombre) {
        boolean deleted = empresas_afiliadas_service.deleteByNombreEmpresasAfiliadas(nombre);

        if (deleted) {
            return ResponseEntity.ok("Eliminado Correctamente, nombre: " + nombre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
