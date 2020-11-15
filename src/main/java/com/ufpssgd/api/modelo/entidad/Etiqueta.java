package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Etiqueta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@ManyToMany(mappedBy = "etiqueta")
	@JsonIgnoreProperties(value = "etiqueta", allowSetters = true)
	private Set<Documento> documento;
	private static final long serialVersionUID = 1L;

	public Etiqueta() {
	}

	public Etiqueta(Long id, String descripcion, Set<Documento> documento) {
		this.id = id;
		this.descripcion = descripcion;
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Etiqueta [id=" + id + ", descripcion=" + descripcion + ", documento=" + documento + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Documento> getDocumento() {
		return documento;
	}

	public void setDocumento(Set<Documento> documento) {
		this.documento = documento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
