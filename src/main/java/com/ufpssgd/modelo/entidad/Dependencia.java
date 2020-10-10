package com.ufpssgd.modelo.entidad;

import java.io.Serializable;

public class Dependencia implements Serializable {

	private Long id;
	private String nombre;
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
