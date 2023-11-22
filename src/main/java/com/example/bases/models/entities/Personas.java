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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_persona")
    private int id_persona;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_empresa")
    private int id_empresa;
    @Column(name = "nombre_persona",length = 50)
    private String nombre;
    @Column(name = "numero_contacto")
    private int numero_contacto;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Facturas> facturas_genera;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Facturas> facturas_adquiere;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Personas persona_empresa;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Devoluciones> devoluciones_persona;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Ofrecimientos> ofrecimientos_persona;
}
