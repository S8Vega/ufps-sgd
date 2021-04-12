package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.DependenciaService;
import com.ufps.sgd.persistence.entity.Dependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencia")
public class DependenciaController {

    @Autowired
    private DependenciaService dependenciaService;

    @GetMapping("/{id}")
    public Dependencia buscar(@PathVariable Long id) {
        return this.dependenciaService.findById(id);
    }

    @GetMapping
    public List<Dependencia> listar() {
        return this.dependenciaService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Dependencia dependencia) {
        this.dependenciaService.save(dependencia);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Dependencia dependencia) {
        dependencia.setId(id);
        this.dependenciaService.save(dependencia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.dependenciaService.deleteById(id);
    }
}
