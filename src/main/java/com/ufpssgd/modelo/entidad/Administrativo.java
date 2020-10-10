package com.ufpssgd.modelo.entidad;

import java.io.Serializable;

public class Administrativo implements Serializable {
	
	private Long id;
	private Dependencia dependencia;
	private Usuario usuario;
	private static final long serialVersionUID = 1L;

	public Administrativo() {
		super();
	}

	public Administrativo(Long id, Dependencia dependencia, Usuario usuario) {
		super();
		this.id = id;
		this.dependencia = dependencia;
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Administrativo [id=" + id + ", dependencia=" + dependencia + ", usuario=" + usuario + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
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
