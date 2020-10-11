package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estado")
public class Estado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@OneToMany(mappedBy = "estado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "estado", allowSetters = true)
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
