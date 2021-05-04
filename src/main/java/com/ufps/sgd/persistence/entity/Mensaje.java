package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String asunto;
    @NonNull
    private String descripcion;
    @OneToMany(mappedBy = "mensaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"numeroRadicado", "nombre", "mensaje", "etiqueta"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Set<Documento> documento;
    @ManyToOne
    @JoinColumn(name = "remitente")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Usuario remitente;
    @ManyToOne
    @JoinColumn(name = "receptor")
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "rol", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Usuario receptor;
    @NonNull
    private Date fechaEnvio;
    @NonNull
    private String estado;
    @OneToOne(mappedBy = "mensajeSiguiente", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Respuesta respuestaAnterior;
    @OneToOne(mappedBy = "mensajeAnterior", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"mensajeAnterior", "mensajeSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Respuesta respuestaSiguiente;
}
