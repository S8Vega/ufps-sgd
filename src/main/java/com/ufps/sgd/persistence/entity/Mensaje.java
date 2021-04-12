package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asunto;
    private String descripcion;
    @OneToMany(mappedBy = "mensaje", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"numeroRadicado", "nombre", "archivo", "mensaje", "etiqueta"}, allowSetters = true)
    private Set<Documento> documento;
    @ManyToOne
    @JoinColumn(name = "remitente")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "docente", "administrativo", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    private Usuario remitente;
    @ManyToOne
    @JoinColumn(name = "receptor")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "docente", "administrativo", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    private Usuario receptor;
    private Date fechaEnvio;
    private String estado;
    @OneToOne(mappedBy = "mensajeSiguiente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    private Respuesta respuestaAnterior;
    @OneToOne(mappedBy = "mensajeAnterior", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    private Respuesta respuestaSiguiente;

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
}
