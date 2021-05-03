package com.ufps.sgd;

import com.ufps.sgd.domain.service.EtiquetaService;
import com.ufps.sgd.persistence.entity.Etiqueta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class EtiquetaTest {

    @Autowired
    private EtiquetaService servicio;

    @Test
    void crud() {
        Etiqueta expected, actual;
        ArrayList<Etiqueta> listaExpected = (ArrayList<Etiqueta>) servicio.findAll();
        for (int i = 0; i < 10; i++) {
            expected = new Etiqueta();
            expected.setDescripcion("descripcion: " + i);
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
