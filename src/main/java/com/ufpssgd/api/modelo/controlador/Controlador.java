package com.ufpssgd.api.modelo.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controlador {

	@RequestMapping
	public String listar() {
		return "conectado";
	}
}
