package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"departamento", "usuario"}, allowSetters = true)
    private Set<Docente> docente;

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
