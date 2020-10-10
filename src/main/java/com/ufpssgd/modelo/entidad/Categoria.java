package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Categoria implements Serializable {

	private Long id;
	private String descripcion;
	private List<Documento> documento;
	private static final long serialVersionUID = 1L;

	public Categoria() {
		super();
	}

	public Categoria(Long id, String descripcion, List<Documento> documento) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descripcion=" + descripcion + ", documento=" + documento + "]";
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
