package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.EtiquetaService;
import com.ufps.sgd.persistence.entity.Etiqueta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController {

    @Autowired
    private EtiquetaService etiquetaService;

    @GetMapping("/{id}")
    public Etiqueta buscar(@PathVariable Long id) {
        return this.etiquetaService.findById(id);
    }

    @GetMapping
    public List<Etiqueta> listar() {
        return this.etiquetaService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Etiqueta etiqueta) {
        this.etiquetaService.save(etiqueta);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Etiqueta etiqueta) {
        etiqueta.setId(id);
        this.etiquetaService.save(etiqueta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.etiquetaService.deleteById(id);
    }
}
