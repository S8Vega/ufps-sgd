package com.ufpssgd.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "docente")
public class Docente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "departamento")
	@JsonIgnoreProperties(value = "docente", allowSetters = true)
	private Departamento departamento;
	@OneToOne
	@JoinColumn(name = "docente", unique = true)
	@JsonIgnoreProperties(value = "docente", allowSetters = true)
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
