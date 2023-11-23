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

    @EmbeddedId
    private OfrecimientosID primaryKey;

    @Column(name = "precio_ofrecimiento")
    private float precio_ofrecimiento;

}
