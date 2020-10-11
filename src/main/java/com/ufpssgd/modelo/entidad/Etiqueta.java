package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "etiqueta")
public class Etiqueta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@ManyToMany(mappedBy = "etiqueta")
	@JsonIgnoreProperties(value = "etiqueta", allowSetters = true)
	private List<Documento> documento;
	private static final long serialVersionUID = 1L;

	public Etiqueta() {
		super();
	}

	public Etiqueta(Long id, String descripcion, List<Documento> documento) {
		super();
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

	public List<Documento> getDocumento() {
		return documento;
	}

	public void setDocumento(List<Documento> documento) {
		this.documento = documento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
