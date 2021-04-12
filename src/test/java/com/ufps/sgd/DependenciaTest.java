package com.ufps.sgd;

import com.ufps.sgd.domain.service.DependenciaService;
import com.ufps.sgd.persistence.entity.Dependencia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DependenciaTest {

    @Autowired
    private DependenciaService servicio;

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
