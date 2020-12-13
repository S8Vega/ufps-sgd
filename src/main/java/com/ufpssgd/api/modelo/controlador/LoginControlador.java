package com.ufpssgd.api.modelo.controlador;

import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlador {

	@GetMapping
	public String login(Map<String, Object> model) {
		return "index";
	}
}
