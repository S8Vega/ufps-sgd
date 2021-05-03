package com.ufps.sgd.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Administrativo extends Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @OneToOne
    @JoinColumn(name = "dependencia", unique = true)
    @JsonIgnoreProperties(value = {"nombre", "administrativo", "numero"}, allowSetters = true)
    private Dependencia dependencia;
}
