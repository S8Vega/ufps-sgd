package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "departamento", allowSetters = true)
    private Set<Docente> docente;

    public Departamento() {
    }

    public Departamento(Long id, String nombre, Set<Docente> docente) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nombre=" + nombre + ", docente=" + docente + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Departamento other = (Departamento) obj;
        return nombre.equals(other.getNombre());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Docente> getDocente() {
        return docente;
    }

    public void setDocente(Set<Docente> docente) {
        this.docente = docente;
    }

}
