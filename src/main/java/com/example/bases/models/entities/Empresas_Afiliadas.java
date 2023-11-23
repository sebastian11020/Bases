package com.example.bases.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPRESAS_AFILIADAS")
public class Empresas_Afiliadas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_empresa")
    private int id_empresa;
    @Column(name = "nombre_empresa",length = 50)
    private String nombre;

    /*@OneToMany(mappedBy = "empresa_afiliada", cascade = CascadeType.ALL)
    private List<Personas> personas_empresa;*/
}
