package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Administrativo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "dependencia", unique = true)
	@JsonIgnoreProperties(value = "administrativo", allowSetters = true)
	private Dependencia dependencia;
	@OneToOne
	@JoinColumn(name = "usuario", unique = true)
	@JsonIgnoreProperties(value = "administrativo", allowSetters = true)
	private Usuario usuario;
	private static final long serialVersionUID = 1L;

	public Administrativo() {
	}

	public Administrativo(Long id, Dependencia dependencia, Usuario usuario) {
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
