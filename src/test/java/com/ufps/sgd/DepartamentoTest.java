package com.ufps.sgd;

import com.ufps.sgd.domain.service.DepartamentoService;
import com.ufps.sgd.persistence.entity.Departamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class DepartamentoTest {

    @Autowired
    private DepartamentoService servicio;

    @Test
    void crud() {
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
