package com.ufps.sgd.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String contrasena;

    public Administrador() {
    }

    public Administrador(Long id, String alias, String contrasena) {
        this.id = id;
        this.alias = alias;
        this.contrasena = contrasena;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Administrador [id=" + id + ", alias=" + alias + ", contrasena=" + contrasena + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Administrador other = (Administrador) obj;
        return alias.equals(other.getAlias()) && contrasena.equals(other.getContrasena());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
