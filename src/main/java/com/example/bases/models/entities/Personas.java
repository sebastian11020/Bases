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
@Table(name = "PERSONAS")
public class Personas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_persona", insertable = false, updatable = false)
    private int id_persona;
    @Column(name = "nombre_persona",length = 50)
    private String nombre;
    @Column(name = "numero_contacto")
    private int numero_contacto;

    @OneToMany(mappedBy = "persona_genera", cascade = CascadeType.ALL)
    private List<Facturas> facturas_genera;

    @OneToMany(mappedBy = "persona_adquiere", cascade = CascadeType.ALL)
    private List<Facturas> facturas_adquiere;

    @OneToMany(mappedBy = "persona_devolucion", cascade = CascadeType.ALL)
    private List<Devoluciones> devoluciones_persona;

    /*OneToMany(mappedBy = "persona_ofrecimientos", cascade = CascadeType.ALL)
    private List<Ofrecimientos> ofrecimientos_persona;*/

    @ManyToOne
    private Empresas_Afiliadas empresa_persona;
}
