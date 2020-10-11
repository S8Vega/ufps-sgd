package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "departamento", allowSetters = true)
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
