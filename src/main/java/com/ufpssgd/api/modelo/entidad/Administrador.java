package com.ufpssgd.api.modelo.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String alias;
	private String contrasena;
	private static final long serialVersionUID = 1L;

	public Administrador() {
	}

	public Administrador(Long id, String alias, String contrasena) {
		this.id = id;
		this.alias = alias;
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", alias=" + alias + ", contrasena=" + contrasena + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Administrador other = (Administrador) obj;
		return alias.equals(other.getAlias()) && contrasena.equals(other.getContrasena());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
