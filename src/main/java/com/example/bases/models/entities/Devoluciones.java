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
@Table(name = "DEVOLUCIONES")
public class Devoluciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_devolucion")
    private int id_devolucion;

    @Column(name = "motivo_devolucion",length = 100)
    private String motivo_devolucion;

    @OneToOne(mappedBy = "devoluciones_detallesFacturas")
    private Detalles_Facturas detalles_facturas;

    @ManyToOne
    private Personas persona_devolucion;
}
