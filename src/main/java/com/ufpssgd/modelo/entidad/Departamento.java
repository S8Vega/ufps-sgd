package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Departamento implements Serializable {

	private Long id;
	private String nombre;
	private List<Docente> docente;
	private static final long serialVersionUID = 1L;

	public Departamento() {
		super();
	}

	public Departamento(Long id, String nombre, List<Docente> docente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre + ", docente=" + docente + "]";
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

	public List<Docente> getDocente() {
		return docente;
	}

	public void setDocente(List<Docente> docente) {
		this.docente = docente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
