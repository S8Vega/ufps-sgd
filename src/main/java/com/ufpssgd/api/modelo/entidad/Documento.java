package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "documento")
public class Documento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroRadicado;
	@ManyToOne
	@JoinColumn(name = "mensaje")
	@JsonIgnoreProperties(value = "documento", allowSetters = true)
	private Mensaje mensaje;
	@ManyToOne
	@JoinColumn(name = "categoria")
	@JsonIgnoreProperties(value = "documento", allowSetters = true)
	private Categoria categoria;
	@ManyToMany
	@JoinTable(name = "documento_etiqueta", joinColumns = @JoinColumn(name = "documento_id"), inverseJoinColumns = @JoinColumn(name = "etiqueta_id"))
	@JsonIgnoreProperties(value = "documento", allowSetters = true)
	private List<Etiqueta> etiqueta;
	private static final long serialVersionUID = 1L;

	public Documento() {
		super();
	}

	public Documento(Long id, Long numeroRadicado, Mensaje mensaje, Categoria categoria, List<Etiqueta> etiqueta) {
		super();
		this.id = id;
		this.numeroRadicado = numeroRadicado;
		this.mensaje = mensaje;
		this.categoria = categoria;
		this.etiqueta = etiqueta;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", numeroRadicado=" + numeroRadicado + ", mensaje=" + mensaje + ", categoria="
				+ categoria + ", etiqueta=" + etiqueta + "]";
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

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Etiqueta> getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(List<Etiqueta> etiqueta) {
		this.etiqueta = etiqueta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
