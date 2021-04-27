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
class UsuarioTest {

    @Autowired
    private UsuarioService servicio;
    @Autowired
    private MensajeService mensajeService;

    @Test
    void crud() {
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

    @Test
    void remitenteReceptor() {
        Usuario remitente, receptor;
        Mensaje mensajeExpected, mensajeActual;
        ArrayList<Mensaje> mensajes;
        ArrayList<Usuario> listaUsuarioExpected = (ArrayList<Usuario>) servicio.findAll();
        ArrayList<Mensaje> listaMensajeExpected = (ArrayList<Mensaje>) mensajeService.findAll();
        for (int i = 0; i < 1; i++) {
            remitente = new Usuario();
            remitente.setNombre("remitente nombre: " + (i + 1));
            remitente.setApellido("remitente apellido: " + (i + 1));
            remitente.setAlias("remitente alias: " + (i + 1));
            remitente.setContrasena("remitente contrasena: " + (i + 1));
            receptor = new Usuario();
            receptor.setNombre("receptor nombre: " + (i + 1));
            receptor.setApellido("receptor apellido: " + (i + 1));
            receptor.setAlias("receptor alias: " + (i + 1));
            receptor.setContrasena("receptor contrasena: " + (i + 1));
            servicio.save(remitente);
            servicio.save(receptor);
            mensajeExpected = new Mensaje();
            mensajeExpected.setRemitente(remitente);
            mensajeExpected.setReceptor(receptor);
            mensajeExpected.setAsunto("asunto: " + (i + 1));
            mensajeExpected.setDescripcion("descripcion: " + (i + 1));
            mensajeExpected.setEstado("estado: " + (i + 1));
            mensajeService.save(mensajeExpected);
            mensajes = (ArrayList<Mensaje>) servicio.findByReceptor(receptor.getId());
            mensajeActual = mensajes.get(0);
            assertEquals(mensajeExpected, mensajeActual);
            mensajes = (ArrayList<Mensaje>) servicio.findByRemitente(remitente.getId());
            mensajeActual = mensajes.get(0);
            assertEquals(mensajeExpected, mensajeActual);
            mensajeService.deleteById(mensajeExpected.getId());
            servicio.deleteById(remitente.getId());
            servicio.deleteById(receptor.getId());
        }
        ArrayList<Usuario> listaUsuarioActual = (ArrayList<Usuario>) servicio.findAll();
        ArrayList<Mensaje> listaMensajeActual = (ArrayList<Mensaje>) mensajeService.findAll();
        System.out.println(listaMensajeExpected.size());
        System.out.println(listaMensajeActual.size());
        assertEquals(listaMensajeExpected, listaMensajeActual);
        assertEquals(listaUsuarioExpected, listaUsuarioActual);
    }

    @Test
    @Timeout(value = 35, unit = TimeUnit.SECONDS)
    void stress() {
        Usuario expected;
        ArrayList<Usuario> listaExpected = (ArrayList<Usuario>) servicio.findAll();
        for (int i = 0; i < 1000; i++) {
            expected = new Usuario(null, "nombre: " + i, "apellido: " + i, "alias: " + i, "contrasena: " + i, null,
                    null, null, null);
            servicio.save(expected);
            servicio.deleteById(expected.getId());
        }
        ArrayList<Usuario> listaActual = (ArrayList<Usuario>) servicio.findAll();
        assertEquals(listaExpected, listaActual);
    }

}
