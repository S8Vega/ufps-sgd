package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "mensajeAnterior", unique = true)
    @JsonIgnoreProperties(value = "respuestaAnterior", allowSetters = true)
    private Mensaje mensajeAnterior;
    @OneToOne
    @JoinColumn(name = "mensajeSiguiente", unique = true)
    @JsonIgnoreProperties(value = "respuestaSiguiente", allowSetters = true)
    private Mensaje mensajeSiguiente;

    public Respuesta() {
    }

    public Respuesta(Long id, Mensaje mensajeAnterior, Mensaje mensajeSiguiente) {
        this.id = id;
        this.mensajeAnterior = mensajeAnterior;
        this.mensajeSiguiente = mensajeSiguiente;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Respuesta [id=" + id + ", mensajeAnterior=" + mensajeAnterior + ", mensajeSiguiente=" + mensajeSiguiente
                + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mensaje getMensajeAnterior() {
        return mensajeAnterior;
    }

    public void setMensajeAnterior(Mensaje mensajeAnterior) {
        this.mensajeAnterior = mensajeAnterior;
    }

    public Mensaje getMensajeSiguiente() {
        return mensajeSiguiente;
    }

    public void setMensajeSiguiente(Mensaje mensajeSiguiente) {
        this.mensajeSiguiente = mensajeSiguiente;
    }

}
