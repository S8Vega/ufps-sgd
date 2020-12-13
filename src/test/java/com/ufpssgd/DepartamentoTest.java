package com.ufpssgd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufpssgd.api.modelo.entidad.Departamento;
import com.ufpssgd.api.modelo.servicio.implementacion.DepartamentoServicioImpl;

@SpringBootTest
class DepartamentoTest {

	@Autowired
	private DepartamentoServicioImpl servicio;

	@Test
	void test() {
		Departamento expected, actual;
		ArrayList<Departamento> listaExpected = (ArrayList<Departamento>) servicio.findAll();
		for (int i = 0; i < 10; i++) {
			expected = new Departamento(null, "nombre: " + i, null);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			expected.setNombre("nombre: " + (i + 1));
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			// test: deleteById
			servicio.deleteById(expected.getId());
			actual = servicio.findById(expected.getId());
			assertNull(actual);
		}
		ArrayList<Departamento> listaActual = (ArrayList<Departamento>) servicio.findAll();
		assertEquals(listaExpected, listaActual);
	}
}
