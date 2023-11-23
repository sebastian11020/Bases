package com.example.bases.models.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Embeddable
public class OfrecimientosID implements java.io.Serializable{

    @ManyToOne @JoinColumn (name ="id_persona" ,referencedColumnName ="id_persona" )
    private Personas persona_ofrecimientos;

    @ManyToOne @JoinColumn (name ="id_producto" ,referencedColumnName ="id_producto" )
    private Productos producto_ofrecimientos;

}
