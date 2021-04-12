package com.ufps.sgd;

import com.ufps.sgd.domain.service.UsuarioService;
import com.ufps.sgd.persistence.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UsuarioTest {

    @Autowired
    private UsuarioService servicio;

    @Test
    void test() {
        Usuario expected, actual;
        ArrayList<Usuario> listaExpected = (ArrayList<Usuario>) servicio.findAll();
        for (int i = 0; i < 10; i++) {
            expected = new Usuario(null, "nombre: " + i, "apellido: " + i, "alias: " + i, "contrasena: " + i, null,
                    null, null, null);
            // test: save
            servicio.save(expected);
            actual = servicio.findById(expected.getId());
            assertEquals(expected, actual);
            expected.setNombre("nombre: " + (i + 1));
            expected.setApellido("apellido: " + (i + 1));
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
        ArrayList<Usuario> listaActual = (ArrayList<Usuario>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }
}
