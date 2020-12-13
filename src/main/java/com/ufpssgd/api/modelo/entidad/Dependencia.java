package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Dependencia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToOne(mappedBy = "dependencia", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "dependencia", allowSetters = true)
	private Administrativo administrativo;
	private Long numero;
	private static final long serialVersionUID = 1L;

	public Dependencia() {
	}

	public Dependencia(Long id, String nombre, Administrativo administrativo, Long numero) {
		this.id = id;
		this.nombre = nombre;
		this.administrativo = administrativo;
		this.numero = numero;
	}

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
