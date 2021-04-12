package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.DocenteService;
import com.ufps.sgd.persistence.entity.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/{id}")
    public Docente buscar(@PathVariable Long id) {
        return this.docenteService.findById(id);
    }

    @GetMapping
    public List<Docente> listar() {
        return this.docenteService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Docente docente) {
        this.docenteService.save(docente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Docente docente) {
        docente.setId(id);
        this.docenteService.save(docente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.docenteService.deleteById(id);
    }
}
