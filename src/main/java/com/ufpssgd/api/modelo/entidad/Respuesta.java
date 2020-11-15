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
public class Respuesta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "mensajeAnterior", unique = true)
	@JsonIgnoreProperties(value = "respuestaAnterior", allowSetters = true)
	private Mensaje mensajeAnterior;
	@OneToOne
	@JoinColumn(name = "mensajeSiguiente", unique = true)
	@JsonIgnoreProperties(value = "respuestaSiguiente", allowSetters = true)
	private Mensaje mensajeSiguiente;
	private static final long serialVersionUID = 1L;

	public Respuesta() {
	}

	public Respuesta(Long id, Mensaje mensajeAnterior, Mensaje mensajeSiguiente) {
		this.id = id;
		this.mensajeAnterior = mensajeAnterior;
		this.mensajeSiguiente = mensajeSiguiente;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", mensajeAnterior=" + mensajeAnterior + ", mensajeSiguiente=" + mensajeSiguiente
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mensaje getMensajeAnterior() {
		return mensajeAnterior;
	}

	public void setMensajeAnterior(Mensaje mensajeAnterior) {
		this.mensajeAnterior = mensajeAnterior;
	}

	public Mensaje getMensajeSiguiente() {
		return mensajeSiguiente;
	}

	public void setMensajeSiguiente(Mensaje mensajeSiguiente) {
		this.mensajeSiguiente = mensajeSiguiente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
