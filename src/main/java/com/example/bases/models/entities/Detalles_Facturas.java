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
@Table(name = "DETALLES_FACTURAS")
public class Detalles_Facturas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_devoluciones")
    private int id_devoluciones;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_producto")
    private int id_producto;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_factura")
    private int id_factura;
    @Column(name = "cantidad_producto")
    private float cantidad_producto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pk_Detalles_Facturas_Devoluciones", referencedColumnName = "id_devoluciones")
    private Devoluciones devoluciones_detallesFacturas;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Detalles_Facturas detallesFacturas_factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Detalles_Facturas detallesFacturas_productos;
}
