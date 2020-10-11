package com.ufpssgd.modelo.entidad;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dependencia")
public class Dependencia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToOne(mappedBy = "dependencia", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "dependencia", allowSetters = true)
	private Administrativo responsable;
	private Long numero;
	private static final long serialVersionUID = 1L;

	public Dependencia() {
		super();
	}

	public Dependencia(Long id, String nombre, Administrativo responsable, Long numero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.responsable = responsable;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Dependencia [id=" + id + ", nombre=" + nombre + ", responsable=" + responsable + ", numero=" + numero
				+ "]";
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

	public Administrativo getResponsable() {
		return responsable;
	}

	public void setResponsable(Administrativo responsable) {
		this.responsable = responsable;
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
