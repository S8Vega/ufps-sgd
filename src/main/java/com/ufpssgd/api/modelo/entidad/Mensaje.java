package com.ufpssgd.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mensaje")
public class Mensaje implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	@OneToMany(mappedBy = "mensaje", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties(value = "mensaje", allowSetters = true)
	private List<Documento> documento;
	@ManyToOne
	@JoinColumn(name = "remitente")
	@JsonIgnoreProperties(value = "mensaje", allowSetters = true)
	private Usuario remitente;
	@ManyToOne
	@JoinColumn(name = "receptor")
	@JsonIgnoreProperties(value = "mensaje", allowSetters = true)
	private Usuario receptor;
	private Date fechaEnvio;
	@ManyToOne
	@JoinColumn(name = "estado")
	@JsonIgnoreProperties(value = "mensaje", allowSetters = true)
	private Estado estado;
	@OneToOne(mappedBy = "respuesta", cascade = CascadeType.REMOVE)
	@JoinColumn(name = "respuesta", unique = true)
	@JsonIgnoreProperties(value = "respuesta", allowSetters = true)
	private Mensaje respuesta;
	private static final long serialVersionUID = 1L;

	public Mensaje() {
		super();
	}

	public Mensaje(Long id, String descripcion, List<Documento> documento, Usuario remitente, Usuario receptor,
			Date fechaEnvio, Estado estado, Mensaje respuesta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.documento = documento;
		this.remitente = remitente;
		this.receptor = receptor;
		this.fechaEnvio = fechaEnvio;
		this.estado = estado;
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", descripcion=" + descripcion + ", documento=" + documento + ", remitente="
				+ remitente + ", receptor=" + receptor + ", fechaEnvio=" + fechaEnvio + ", estado=" + estado
				+ ", respuesta=" + respuesta + "]";
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

	public List<Documento> getDocumento() {
		return documento;
	}

	public void setDocumento(List<Documento> documento) {
		this.documento = documento;
	}

	public Usuario getRemitente() {
		return remitente;
	}

	public void setRemitente(Usuario remitente) {
		this.remitente = remitente;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Mensaje getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Mensaje respuesta) {
		this.respuesta = respuesta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
