package com.ufps.sgd.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String contrasena;

    @Override
    public String toString() {
        return "Administrador [id=" + id + ", alias=" + alias + ", contrasena=" + contrasena + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Administrador other = (Administrador) obj;
        return alias.equals(other.getAlias()) && contrasena.equals(other.getContrasena());
    }
}
