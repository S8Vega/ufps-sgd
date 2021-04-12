package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numeroRadicado;
    private String nombre;
    private String archivo;
    @ManyToOne
    @JoinColumn(name = "mensaje")
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    private Mensaje mensaje;
    @ManyToMany
    @JoinTable(name = "documento_etiqueta", joinColumns = @JoinColumn(name = "documento_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
    @JsonIgnoreProperties(value = {"descripcion", "documento"}, allowSetters = true)
    private Set<Etiqueta> etiqueta;

    @Override
    public String toString() {
        return "Documento [id=" + id + ", numeroRadicado=" + numeroRadicado + ", nombre=" + nombre + ", archivo="
                + archivo + ", mensaje=" + mensaje + ", etiqueta=" + etiqueta + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Documento other = (Documento) obj;
        return numeroRadicado.equals(other.getNumeroRadicado()) && nombre.equals(other.getNombre())
                && archivo.equals(other.getArchivo());
    }
}
