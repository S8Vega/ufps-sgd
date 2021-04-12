package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.MensajeService;
import com.ufps.sgd.persistence.entity.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @GetMapping("/{id}")
    public Mensaje buscar(@PathVariable Long id) {
        return this.mensajeService.findById(id);
    }

    @GetMapping
    public List<Mensaje> listar() {
        return this.mensajeService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Mensaje mensaje) {
        this.mensajeService.save(mensaje);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Mensaje mensaje) {
        mensaje.setId(id);
        this.mensajeService.save(mensaje);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.mensajeService.deleteById(id);
    }
}
