package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "departamento")
    @JsonIgnoreProperties(value = "docente", allowSetters = true)
    private Departamento departamento;
    @OneToOne
    @JoinColumn(name = "usuario", unique = true)
    @JsonIgnoreProperties(value = "docente", allowSetters = true)
    private Usuario usuario;

    public Docente() {
    }

    public Docente(Long id, Departamento departamento, Usuario usuario) {
        this.id = id;
        this.departamento = departamento;
        this.usuario = usuario;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Docente [id=" + id + ", departamento=" + departamento + ", usuario=" + usuario + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
