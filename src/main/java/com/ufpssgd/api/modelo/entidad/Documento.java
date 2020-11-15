package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Documento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroRadicado;
	private String nombre;
	private String archivo;
	@ManyToOne
	@JoinColumn(name = "mensaje")
	@JsonIgnoreProperties(value = "documento", allowSetters = true)
	private Mensaje mensaje;
	@ManyToMany
	@JoinTable(name = "documento_etiqueta", joinColumns = @JoinColumn(name = "documento_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
	@JsonIgnoreProperties(value = "documento", allowSetters = true)
	private Set<Etiqueta> etiqueta;
	private static final long serialVersionUID = 1L;

	public Documento() {
	}

	public Documento(Long id, Long numeroRadicado, String nombre, String archivo, Mensaje mensaje,
			Set<Etiqueta> etiqueta) {
		this.id = id;
		this.numeroRadicado = numeroRadicado;
		this.nombre = nombre;
		this.archivo = archivo;
		this.mensaje = mensaje;
		this.etiqueta = etiqueta;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", numeroRadicado=" + numeroRadicado + ", nombre=" + nombre + ", archivo="
				+ archivo + ", mensaje=" + mensaje + ", etiqueta=" + etiqueta + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroRadicado() {
		return numeroRadicado;
	}

	public void setNumeroRadicado(Long numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public Set<Etiqueta> getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Set<Etiqueta> etiqueta) {
		this.etiqueta = etiqueta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
