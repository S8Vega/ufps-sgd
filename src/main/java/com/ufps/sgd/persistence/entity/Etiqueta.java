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
public class Etiqueta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String descripcion;
    @ManyToMany(mappedBy = "etiqueta", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"numeroRadicado", "nombre", "mensaje", "etiqueta"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Set<Documento> documento;
}
