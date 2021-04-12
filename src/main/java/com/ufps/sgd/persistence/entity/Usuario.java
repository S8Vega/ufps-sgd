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
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String alias;
    private String contrasena;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"departamento", "usuario"}, allowSetters = true)
    private Docente docente;
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"dependencia", "usuario"}, allowSetters = true)
    private Administrativo administrativo;
    @OneToMany(mappedBy = "receptor", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    private Set<Mensaje> mensajeEnviado;
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    private Set<Mensaje> mensajeRecibido;

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias
                + ", contrasena=" + contrasena + ", docente=" + docente + ", administrativo=" + administrativo
                + ", mensajeEnviado=" + mensajeEnviado + ", mensajeRecibido=" + mensajeRecibido + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Usuario other = (Usuario) obj;
        return nombre.equals(other.getNombre()) && apellido.equals(other.getApellido())
                && alias.equals(other.getAlias()) && contrasena.equals(other.getContrasena());
    }
}
