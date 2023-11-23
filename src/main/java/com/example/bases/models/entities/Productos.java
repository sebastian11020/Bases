package com.example.bases.models.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTOS")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_producto")
    private int id_producto;
    @Column(name = "descripcion_producto",length = 100)
    private String descripcion_producto;
    @Column(name = "nombre_producto",length = 20)
    private String nombre_producto;
    @Column(name = "precio_venta_producto")
    private float precio_venta_producto;
    @Column(name = "fecha_vencimiento_producto")
    private LocalDate fecha_vencimiento_producto;

    /*@OneToMany(mappedBy = "producto_ofrecimientos", cascade = CascadeType.ALL)
    private List<Ofrecimientos> ofrecimientos_productos;*/

    /*@OneToMany(mappedBy = "detalles_Factura_productos", cascade = CascadeType.ALL)
    private List<Detalles_Facturas> detallesFacturas_productos;*/
}
