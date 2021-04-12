package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.RespuestaService;
import com.ufps.sgd.persistence.entity.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping("/{id}")
    public Respuesta buscar(@PathVariable Long id) {
        return this.respuestaService.findById(id);
    }

    @GetMapping
    public List<Respuesta> listar() {
        return this.respuestaService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Respuesta respuesta) {
        this.respuestaService.save(respuesta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Respuesta respuesta) {
        respuesta.setId(id);
        this.respuestaService.save(respuesta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.respuestaService.deleteById(id);
    }
}
