package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToMany(mappedBy = "etiqueta")
    @JsonIgnoreProperties(value = {"numeroRadicado", "nombre", "archivo", "mensaje", "etiqueta"}, allowSetters = true)
    private Set<Documento> documento;

    @Override
    public String toString() {
        return "Etiqueta [id=" + id + ", descripcion=" + descripcion + ", documento=" + documento + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Etiqueta other = (Etiqueta) obj;
        return descripcion.equals(other.getDescripcion());
    }
}
