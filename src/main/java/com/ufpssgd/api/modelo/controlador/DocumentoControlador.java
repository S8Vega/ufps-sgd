package com.ufpssgd.api.modelo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufpssgd.api.modelo.entidad.Documento;
import com.ufpssgd.api.modelo.servicio.implementacion.DocumentoServicioImpl;

@RestController
@RequestMapping("/documento")
public class DocumentoControlador {

	@Autowired
	private DocumentoServicioImpl servicio;

	@GetMapping("/{id}")
	public Documento buscar(@PathVariable Long id) {
		return this.servicio.findById(id);
	}

	@GetMapping
	public List<Documento> listar() {
		return this.servicio.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Documento t) {
		this.servicio.save(t);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Documento t) {
		t.setId(id);
		this.servicio.save(t);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.servicio.deleteById(id);
	}
}