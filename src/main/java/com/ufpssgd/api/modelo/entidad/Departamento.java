package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Departamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "departamento", allowSetters = true)
	private Set<Docente> docente;
	private static final long serialVersionUID = 1L;

	public Departamento() {
	}

	public Departamento(Long id, String nombre, Set<Docente> docente) {
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

	public Set<Docente> getDocente() {
		return docente;
	}

	public void setDocente(Set<Docente> docente) {
		this.docente = docente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
