package com.ufps.sgd;

import com.ufps.sgd.domain.service.AdministradorService;
import com.ufps.sgd.persistence.entity.Administrador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class AdministradorTest {

    @Autowired
    private AdministradorService servicio;

    @Test
    void crud() {
        Administrador expected, actual;
        ArrayList<Administrador> listaExpected = (ArrayList<Administrador>) servicio.findAll();
        for (int i = 0; i < 10; i++) {
            expected = new Administrador(null, "alias: " + i, "contrasena: " + i);
            // test: save
            servicio.save(expected);
            actual = servicio.findById(expected.getId());
            assertEquals(expected, actual);
            expected.setAlias("alias: " + (i + 1));
            expected.setContrasena("contrasena: " + (i + 1));
            // test: save
            servicio.save(expected);
            actual = servicio.findById(expected.getId());
            assertEquals(expected, actual);
            // test: deleteById
            servicio.deleteById(expected.getId());
            actual = servicio.findById(expected.getId());
            assertNull(actual);
        }
        ArrayList<Administrador> listaActual = (ArrayList<Administrador>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }
}
