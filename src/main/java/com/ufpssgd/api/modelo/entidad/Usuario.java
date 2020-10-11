package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String alias;
	private String contrasena;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "usuario", allowSetters = true)
	private Docente docente;
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "usuario", allowSetters = true)
	private Administrativo administrativo;
	@OneToMany(mappedBy = "remitente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "remitente", allowSetters = true)
	private List<Mensaje> mensajeEnviado;
	@OneToMany(mappedBy = "remitente", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "remitente", allowSetters = true)
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
