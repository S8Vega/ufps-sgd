package com.ufps.sgd;

import com.ufps.sgd.domain.service.DocumentoService;
import com.ufps.sgd.persistence.entity.Documento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DocumentoTest {

    @Autowired
    private DocumentoService servicio;

    @Test
    void crud() {
        Documento expected, actual;
        ArrayList<Documento> listaExpected = (ArrayList<Documento>) servicio.findAll();
        for (int i = 0; i < 10; i++) {
            expected = new Documento(null, (long) i, "nombre: " + i, null, null);
            // test: save
            servicio.save(expected);
            actual = servicio.findById(expected.getId());
            assertEquals(expected, actual);
            expected.setNumeroRadicado((long) i + 1);
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
        ArrayList<Documento> listaActual = (ArrayList<Documento>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }
}
