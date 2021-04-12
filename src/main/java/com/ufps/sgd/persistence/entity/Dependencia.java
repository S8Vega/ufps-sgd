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
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToOne(mappedBy = "dependencia", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"dependencia", "usuario"}, allowSetters = true)
    private Administrativo administrativo;
    private Long numero;

    @Override
    public String toString() {
        return "Dependencia [id=" + id + ", nombre=" + nombre + ", administrativo=" + administrativo + ", numero="
                + numero + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Dependencia other = (Dependencia) obj;
        return nombre.equals(other.getNombre()) && numero.equals(other.getNumero());
    }
}
