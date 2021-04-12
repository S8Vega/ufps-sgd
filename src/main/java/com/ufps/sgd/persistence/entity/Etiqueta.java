package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    @ManyToMany(mappedBy = "etiqueta")
    @JsonIgnoreProperties(value = "etiqueta", allowSetters = true)
    private Set<Documento> documento;

    public Etiqueta() {
    }

    public Etiqueta(Long id, String descripcion, Set<Documento> documento) {
        this.id = id;
        this.descripcion = descripcion;
        this.documento = documento;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Etiqueta [id=" + id + ", descripcion=" + descripcion + ", documento=" + documento + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Etiqueta other = (Etiqueta) obj;
        return descripcion.equals(other.getDescripcion());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Documento> getDocumento() {
        return documento;
    }

    public void setDocumento(Set<Documento> documento) {
        this.documento = documento;
    }

}
