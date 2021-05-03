package com.ufps.sgd;

import com.ufps.sgd.domain.service.MensajeService;
import com.ufps.sgd.domain.service.UsuarioService;
import com.ufps.sgd.persistence.entity.Mensaje;
import com.ufps.sgd.persistence.entity.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class MensajeTest {

    @Autowired
    private MensajeService servicio;
    @Autowired
    private UsuarioService usuarioServicio;

    @Test
    void crud() {
        Mensaje expected, actual;
        ArrayList<Mensaje> listaExpected = (ArrayList<Mensaje>) servicio.findAll();
        Usuario remitente = new Usuario();
        Usuario receptor = new Usuario();
        remitente.setNombre("nombre remitente");
        remitente.setApellido("apellido remitente");
        remitente.setAlias("alias remitente");
        remitente.setContrasena("contrasena remitente");
        receptor.setNombre("nombre receptor");
        receptor.setApellido("apellido receptor");
        receptor.setAlias("alias receptor");
        receptor.setContrasena("contrasena receptor");
        usuarioServicio.save(remitente);
        usuarioServicio.save(receptor);
        for (int i = 0; i < 10; i++) {
            expected = new Mensaje();
            expected.setAsunto("asunto: " + i);
            expected.setDescripcion("descripcion: " + i);
            expected.setRemitente(remitente);
            expected.setReceptor(receptor);
            expected.setEstado("enviado");
            // test: save
            servicio.save(expected);
            actual = servicio.findById(expected.getId());
            assertEquals(expected, actual);
            expected.setAsunto("asunto: " + (i + 1));
            expected.setDescripcion("descripcion: " + (i + 1));
            // test: save
            servicio.save(expected);
            actual = servicio.findById(actual.getId());
            assertEquals(expected, actual);
            // test: deleteById
            servicio.deleteById(expected.getId());
            actual = servicio.findById(actual.getId());
            assertNull(actual);
        }
        usuarioServicio.deleteById(remitente.getId());
        usuarioServicio.deleteById(receptor.getId());
        ArrayList<Mensaje> listaActual = (ArrayList<Mensaje>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }


    @Test
    @Timeout(value = 1, unit = TimeUnit.MINUTES)
    void stress() {
        Mensaje expected;
        ArrayList<Mensaje> listaExpected = (ArrayList<Mensaje>) servicio.findAll();
        Usuario remitente = new Usuario();
        Usuario receptor = new Usuario();
        remitente.setNombre("nombre remitente");
        remitente.setApellido("apellido remitente");
        remitente.setAlias("alias remitente");
        remitente.setContrasena("contrasena remitente");
        receptor.setNombre("nombre receptor");
        receptor.setApellido("apellido receptor");
        receptor.setAlias("alias receptor");
        receptor.setContrasena("contrasena receptor");
        usuarioServicio.save(remitente);
        usuarioServicio.save(receptor);
        for (int i = 0; i < 1000; i++) {
            expected = new Mensaje();
            expected.setAsunto("asunto: " + i);
            expected.setDescripcion("descripcion: " + i);
            expected.setRemitente(remitente);
            expected.setReceptor(receptor);
            expected.setEstado("enviado");
            servicio.save(expected);
            servicio.deleteById(expected.getId());
        }
        usuarioServicio.deleteById(remitente.getId());
        usuarioServicio.deleteById(receptor.getId());
        ArrayList<Mensaje> listaActual = (ArrayList<Mensaje>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }
}
