package com.example.bases.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FACTURAS")
public class Facturas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_factura")
    private int id_factura;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_persona_genera")
    private int id_persona_genera;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_persona_adquiere")
    private int id_persona_adquiere;
    @Column(name = "fecha_factura")
    private LocalDateTime fecha_factura;
    @Column(name = "precio_producto_factura")
    private float precio_producto_factura;
    @Column(name = "si_pago")
    private boolean si_pago;
    @Column(name = "tipo_factura")
    private TIPO_FACTURA tipo_factura;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<Detalles_Facturas> detallesFacturas_facturas;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Personas persona_genera;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Personas persona_adquiere;
}
