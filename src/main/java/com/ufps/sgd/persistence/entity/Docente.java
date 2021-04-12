package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "departamento")
    @JsonIgnoreProperties(value = {"nombre", "docente"}, allowSetters = true)
    private Departamento departamento;
    @OneToOne
    @JoinColumn(name = "usuario", unique = true)
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "docente", "administrativo", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    private Usuario usuario;

    @Override
    public String toString() {
        return "Docente [id=" + id + ", departamento=" + departamento + ", usuario=" + usuario + "]";
    }
}
