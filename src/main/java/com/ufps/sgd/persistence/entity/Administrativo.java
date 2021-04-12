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
public class Administrativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "dependencia", unique = true)
    @JsonIgnoreProperties(value = {"nombre", "administrativo", "numero"}, allowSetters = true)
    private Dependencia dependencia;
    @OneToOne
    @JoinColumn(name = "usuario", unique = true)
    @JsonIgnoreProperties(value = {"nombre", "apellido", "alias", "contrasena", "docente", "administrativo", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    private Usuario usuario;

    @Override
    public String toString() {
        return "Administrativo [id=" + id + ", dependencia=" + dependencia + ", usuario=" + usuario + "]";
    }
}
