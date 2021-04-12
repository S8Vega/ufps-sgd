package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Administrativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "dependencia", unique = true)
    @JsonIgnoreProperties(value = "administrativo", allowSetters = true)
    private Dependencia dependencia;
    @OneToOne
    @JoinColumn(name = "usuario", unique = true)
    @JsonIgnoreProperties(value = "administrativo", allowSetters = true)
    private Usuario usuario;

    public Administrativo() {
    }

    public Administrativo(Long id, Dependencia dependencia, Usuario usuario) {
        this.id = id;
        this.dependencia = dependencia;
        this.usuario = usuario;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Administrativo [id=" + id + ", dependencia=" + dependencia + ", usuario=" + usuario + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
