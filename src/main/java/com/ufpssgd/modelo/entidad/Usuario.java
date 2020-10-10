package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {

	private Long id;
	private String nombre;
	private String apellido;
	private String alias;
	private String contrasena;
	private Docente docente;
	private Administrativo administrativo;
	private List<Mensaje> mensajeEnviado;
	private List<Mensaje> mensajeRecibido;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, String apellido, String alias, String contrasena, Docente docente,
			Administrativo administrativo, List<Mensaje> mensajeEnviado, List<Mensaje> mensajeRecibido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.contrasena = contrasena;
		this.docente = docente;
		this.administrativo = administrativo;
		this.mensajeEnviado = mensajeEnviado;
		this.mensajeRecibido = mensajeRecibido;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias
				+ ", contrasena=" + contrasena + ", docente=" + docente + ", administrativo=" + administrativo
				+ ", mensajeEnviado=" + mensajeEnviado + ", mensajeRecibido=" + mensajeRecibido + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	public List<Mensaje> getMensajeEnviado() {
		return mensajeEnviado;
	}

	public void setMensajeEnviado(List<Mensaje> mensajeEnviado) {
		this.mensajeEnviado = mensajeEnviado;
	}

	public List<Mensaje> getMensajeRecibido() {
		return mensajeRecibido;
	}

	public void setMensajeRecibido(List<Mensaje> mensajeRecibido) {
		this.mensajeRecibido = mensajeRecibido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
