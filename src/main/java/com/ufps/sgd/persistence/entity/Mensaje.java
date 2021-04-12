package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asunto;
    private String descripcion;
    @OneToMany(mappedBy = "mensaje", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "mensaje", allowSetters = true)
    private Set<Documento> documento;
    @ManyToOne
    @JoinColumn(name = "remitente")
    @JsonIgnoreProperties(value = "mensaje", allowSetters = true)
    private Usuario remitente;
    @ManyToOne
    @JoinColumn(name = "receptor")
    @JsonIgnoreProperties(value = "mensaje", allowSetters = true)
    private Usuario receptor;
    private Date fechaEnvio;
    private String estado;
    @OneToOne(mappedBy = "mensajeSiguiente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "mensajeSiguiente", allowSetters = true)
    private Respuesta respuestaAnterior;
    @OneToOne(mappedBy = "mensajeAnterior", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = "mensajeAnterior", allowSetters = true)
    private Respuesta respuestaSiguiente;

    public Mensaje() {
    }

    public Mensaje(Long id, String asunto, String descripcion, Set<Documento> documento, Usuario remitente,
                   Usuario receptor, Date fechaEnvio, String estado, Respuesta respuestaAnterior,
                   Respuesta respuestaSiguiente) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.documento = documento;
        this.remitente = remitente;
        this.receptor = receptor;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.respuestaAnterior = respuestaAnterior;
        this.respuestaSiguiente = respuestaSiguiente;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Mensaje [id=" + id + ", asunto=" + asunto + ", descripcion=" + descripcion + ", documento=" + documento
                + ", remitente=" + remitente + ", receptor=" + receptor + ", fechaEnvio=" + fechaEnvio + ", estado="
                + estado + ", respuestaAnterior=" + respuestaAnterior + ", respuestaSiguiente=" + respuestaSiguiente
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Mensaje other = (Mensaje) obj;
        return asunto.equals(other.getAsunto()) && descripcion.equals(other.getDescripcion())
                && estado.equals(other.getEstado());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Respuesta getRespuestaAnterior() {
        return respuestaAnterior;
    }

    public void setRespuestaAnterior(Respuesta respuestaAnterior) {
        this.respuestaAnterior = respuestaAnterior;
    }

    public Respuesta getRespuestaSiguiente() {
        return respuestaSiguiente;
    }

    public void setRespuestaSiguiente(Respuesta respuestaSiguiente) {
        this.respuestaSiguiente = respuestaSiguiente;
    }

}
