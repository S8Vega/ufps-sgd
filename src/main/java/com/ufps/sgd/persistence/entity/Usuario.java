package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String alias;
    private String contrasena;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "usuario", allowSetters = true)
    private Docente docente;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "usuario", allowSetters = true)
    private Administrativo administrativo;
    @OneToMany(mappedBy = "receptor", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "receptor", allowSetters = true)
    private Set<Mensaje> mensajeEnviado;
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "remitente", allowSetters = true)
    private Set<Mensaje> mensajeRecibido;

    public Usuario() {
    }

    public Usuario(Long id, String nombre, String apellido, String alias, String contrasena, Docente docente,
                   Administrativo administrativo, Set<Mensaje> mensajeEnviado, Set<Mensaje> mensajeRecibido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.contrasena = contrasena;
        this.docente = docente;
        this.administrativo = administrativo;
        this.mensajeEnviado = mensajeEnviado;
        this.mensajeRecibido = mensajeRecibido;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias
                + ", contrasena=" + contrasena + ", docente=" + docente + ", administrativo=" + administrativo
                + ", mensajeEnviado=" + mensajeEnviado + ", mensajeRecibido=" + mensajeRecibido + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Usuario other = (Usuario) obj;
        return nombre.equals(other.getNombre()) && apellido.equals(other.getApellido())
                && alias.equals(other.getAlias()) && contrasena.equals(other.getContrasena());
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }

    public Set<Mensaje> getMensajeEnviado() {
        return mensajeEnviado;
    }

    public void setMensajeEnviado(Set<Mensaje> mensajeEnviado) {
        this.mensajeEnviado = mensajeEnviado;
    }

    public Set<Mensaje> getMensajeRecibido() {
        return mensajeRecibido;
    }

    public void setMensajeRecibido(Set<Mensaje> mensajeRecibido) {
        this.mensajeRecibido = mensajeRecibido;
    }

}
