package com.ufpssgd.modelo.entidad;

import java.io.Serializable;

public class Docente implements Serializable {

	private Long id;
	private Departamento departamento;
	private Usuario usuario;
	private static final long serialVersionUID = 1L;

	public Docente() {
		super();
	}

	public Docente(Long id, Departamento departamento, Usuario usuario) {
		super();
		this.id = id;
		this.departamento = departamento;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", departamento=" + departamento + ", usuario=" + usuario + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
