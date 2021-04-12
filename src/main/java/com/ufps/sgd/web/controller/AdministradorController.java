package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.AdministradorService;
import com.ufps.sgd.persistence.entity.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/{id}")
    public Administrador buscar(@PathVariable Long id) {
        return this.administradorService.findById(id);
    }

    @GetMapping
    public List<Administrador> listar() {
        return this.administradorService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Administrador administrador) {
        this.administradorService.save(administrador);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Administrador administrador) {
        administrador.setId(id);
        this.administradorService.save(administrador);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.administradorService.deleteById(id);
    }
}
