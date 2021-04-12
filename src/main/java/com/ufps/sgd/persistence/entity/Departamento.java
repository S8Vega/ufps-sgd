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
public class Departamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"departamento", "usuario"}, allowSetters = true)
    private Set<Docente> docente;
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nombre=" + nombre + ", docente=" + docente + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Departamento other = (Departamento) obj;
        return nombre.equals(other.getNombre());
    }
}
