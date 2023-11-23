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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int detalles_factura_id;

    @Column(name = "cantidad_producto")
    private float cantidad_producto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_devolucion", referencedColumnName = "id_devolucion")
    private Devoluciones devoluciones_detallesFacturas;

    @ManyToOne
    private Detalles_Facturas detalles_Factura_factura;

    @ManyToOne
    private Detalles_Facturas detalles_Factura_productos;
}
