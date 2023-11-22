package com.example.bases.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OFRECIMIENTOS")
public class Ofrecimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_producto")
    private int id_producto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_persona")
    private int id_persona;
    @Column(name = "precio_ofrecimiento")
    private float precio_ofrecimiento;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Personas persona_ofrecimientos;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto_ofrecimientos;
}
