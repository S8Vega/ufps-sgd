package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Docente extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "departamento")
    @JsonIgnoreProperties(value = {"nombre", "docente"}, allowSetters = true)
    private Departamento departamento;
}
