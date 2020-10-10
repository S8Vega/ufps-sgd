package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Documento implements Serializable {

	private Long id;
	private Long numeroRadicado;
	private Mensaje mensaje;
	private Categoria categoria;
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
