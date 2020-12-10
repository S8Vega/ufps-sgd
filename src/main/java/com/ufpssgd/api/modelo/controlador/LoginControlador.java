package com.ufpssgd.api.modelo.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ufpssgd.api.modelo.servicio.implementacion.UsuarioServicioImpl;

@Controller
public class LoginControlador {

	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	@GetMapping
	public String login() {
		return "login";
	}
}
