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

import com.ufpssgd.api.modelo.entidad.Docente;
import com.ufpssgd.api.modelo.servicio.implementacion.DocenteServicioImpl;

@RestController
@RequestMapping("/docente")
public class DocenteControlador {

	@Autowired
	private DocenteServicioImpl servicio;

	@GetMapping("/{id}")
	public Docente buscar(@PathVariable Long id) {
		return this.servicio.findById(id);
	}

	@GetMapping
	public List<Docente> listar() {
		return this.servicio.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void crear(@RequestBody Docente t) {
		this.servicio.save(t);
	}

	@PutMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void actualizar(@PathVariable Long id, @RequestBody Docente t) {
		t.setId(id);
		this.servicio.save(t);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		this.servicio.deleteById(id);
	}
}
