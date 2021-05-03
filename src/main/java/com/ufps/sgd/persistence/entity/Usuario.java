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
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String apellido;
    @NonNull
    @Column(unique = true)
    private String alias;
    @NonNull
    private String contrasena;
    @NonNull
    private Boolean enabled;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_id", "rol_id"})})
    @EqualsAndHashCode.Exclude
    private Set<Rol> rol;
    @OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Set<Mensaje> mensajeEnviado;
    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"asunto", "descripcion", "documento", "remitente", "receptor", "fechaEnvio", "estado", "respuestaAnterior", "respuestaSiguiente"}, allowSetters = true)
    @EqualsAndHashCode.Exclude
    private Set<Mensaje> mensajeRecibido;

    public void agregarRol(Rol r) {
        this.getRol().add(r);
    }
}
