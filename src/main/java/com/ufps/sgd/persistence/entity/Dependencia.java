package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @OneToOne(mappedBy = "dependencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"dependencia", "nombre", "apellido", "alias", "contrasena", "rol", "mensajeEnviado", "mensajeRecibido"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Administrativo administrativo;
    @NonNull
    private Long numero;
}
