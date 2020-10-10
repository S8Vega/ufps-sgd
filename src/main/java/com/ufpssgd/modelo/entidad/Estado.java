package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Estado implements Serializable {

	private Long id;
	private String descripcion;
	private List<Mensaje> mensaje;
	private static final long serialVersionUID = 1L;

	public Estado() {
		super();
	}

	public Estado(Long id, String descripcion, List<Mensaje> mensaje) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", descripcion=" + descripcion + ", mensaje=" + mensaje + "]";
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

	public List<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
