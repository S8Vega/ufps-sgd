package com.ufpssgd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufpssgd.api.modelo.entidad.Etiqueta;
import com.ufpssgd.api.modelo.servicio.implementacion.EtiquetaServicioImpl;

@SpringBootTest
class EtiquetaTest {

	@Autowired
	private EtiquetaServicioImpl servicio;

	@Test
	void test() {
		Etiqueta expected, actual;
		ArrayList<Etiqueta> listaExpected = (ArrayList<Etiqueta>) servicio.findAll();
		for (int i = 0; i < 10; i++) {
			expected = new Etiqueta(null, "descripcion: " + i, null);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			expected.setDescripcion("descripcion: " + (i + 1));
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			// test: deleteById
			servicio.deleteById(expected.getId());
			actual = servicio.findById(expected.getId());
			assertNull(actual);
		}
		ArrayList<Etiqueta> listaActual = (ArrayList<Etiqueta>) servicio.findAll();
		assertEquals(listaExpected, listaActual);
	}
}
