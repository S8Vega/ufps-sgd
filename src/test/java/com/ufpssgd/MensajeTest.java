package com.ufpssgd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufpssgd.api.modelo.entidad.Mensaje;
import com.ufpssgd.api.modelo.servicio.implementacion.MensajeServicioImpl;
import com.ufpssgd.api.modelo.servicio.implementacion.UsuarioServicioImpl;

@SpringBootTest
class MensajeTest {

	@Autowired
	private MensajeServicioImpl servicio;
	@Autowired
	private UsuarioServicioImpl usuarioServicio;

	@Test
	void test() {
		Mensaje expected, actual;
		ArrayList<Mensaje> listaExpected = (ArrayList<Mensaje>) servicio.findAll();
		for (int i = 0; i < 10; i++) {
			expected = new Mensaje(null, "asunto: " + i, "descripcion: " + i, null, usuarioServicio.findById((long) i),
					usuarioServicio.findById((long) (i % 15 + 1)), null, "enviado", null, null);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			expected.setAsunto("asunto: " + (i + 1));
			expected.setDescripcion("descripcion: " + (i + 1));
			// test: save
			servicio.save(expected);
			actual = servicio.findById(actual.getId());
			assertEquals(expected, actual);
			// test: deleteById
			servicio.deleteById(expected.getId());
			actual = servicio.findById(actual.getId());
			assertNull(actual);
		}
		ArrayList<Mensaje> listaActual = (ArrayList<Mensaje>) servicio.findAll();
		assertEquals(listaExpected, listaActual);
	}
}
