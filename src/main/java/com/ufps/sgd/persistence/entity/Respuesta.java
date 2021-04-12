package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "mensajeAnterior", unique = true)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    private Mensaje mensajeAnterior;
    @OneToOne
    @JoinColumn(name = "mensajeSiguiente", unique = true)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    private Mensaje mensajeSiguiente;

    @Override
    public String toString() {
        return "Respuesta [id=" + id + ", mensajeAnterior=" + mensajeAnterior + ", mensajeSiguiente=" + mensajeSiguiente
                + "]";
    }
}
