package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.DepartamentoService;
import com.ufps.sgd.persistence.entity.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/{id}")
    public Departamento buscar(@PathVariable Long id) {
        return this.departamentoService.findById(id);
    }

    @GetMapping
    public List<Departamento> listar() {
        return this.departamentoService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Departamento departamento) {
        this.departamentoService.save(departamento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
        departamento.setId(id);
        this.departamentoService.save(departamento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.departamentoService.deleteById(id);
    }
}
