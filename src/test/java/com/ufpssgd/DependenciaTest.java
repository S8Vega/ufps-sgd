package com.ufpssgd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufpssgd.api.modelo.entidad.Dependencia;
import com.ufpssgd.api.modelo.servicio.implementacion.DependenciaServicioImpl;

@SpringBootTest
class DependenciaTest {

	@Autowired
	private DependenciaServicioImpl servicio;

	@Test
	void test() {
		Dependencia expected, actual;
		ArrayList<Dependencia> listaExpected = (ArrayList<Dependencia>) servicio.findAll();
		for (int i = 0; i < 10; i++) {
			expected = new Dependencia(null, "nombre: " + i, null, (long) i);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			expected.setNombre("nombre: " + (i + 1));
			expected.setNumero((long) i + 1);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			// test: deleteById
			servicio.deleteById(expected.getId());
			actual = servicio.findById(expected.getId());
			assertNull(actual);
		}
		ArrayList<Dependencia> listaActual = (ArrayList<Dependencia>) servicio.findAll();
		assertEquals(listaExpected, listaActual);
	}

}
