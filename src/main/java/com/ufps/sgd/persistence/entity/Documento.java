package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long numeroRadicado;
    @NonNull
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "mensaje")
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Mensaje mensaje;
    @ManyToMany
    @JoinTable(name = "documento_etiqueta", joinColumns = @JoinColumn(name = "documento_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
    @JsonIgnoreProperties(value = {"descripcion", "documento"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Set<Etiqueta> etiqueta;
}
