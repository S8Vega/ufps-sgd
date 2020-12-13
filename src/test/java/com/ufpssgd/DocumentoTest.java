package com.ufpssgd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufpssgd.api.modelo.entidad.Documento;
import com.ufpssgd.api.modelo.servicio.implementacion.DocumentoServicioImpl;

@SpringBootTest
class DocumentoTest {

	@Autowired
	private DocumentoServicioImpl servicio;

	@Test
	void test() {
		Documento expected, actual;
		ArrayList<Documento> listaExpected = (ArrayList<Documento>) servicio.findAll();
		for (int i = 0; i < 10; i++) {
			expected = new Documento(null, (long) i, "nombre: " + i, "archivo: " + i, null, null);
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			expected.setNumeroRadicado((long) i + 1);
			expected.setNombre("nombre: " + (i + 1));
			expected.setArchivo("archivo: " + (i + 1));
			// test: save
			servicio.save(expected);
			actual = servicio.findById(expected.getId());
			assertEquals(expected, actual);
			// test: deleteById
			servicio.deleteById(expected.getId());
			actual = servicio.findById(expected.getId());
			assertNull(actual);
		}
		ArrayList<Documento> listaActual = (ArrayList<Documento>) servicio.findAll();
		assertEquals(listaExpected, listaActual);
	}
}
