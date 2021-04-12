package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.AdministrativoService;
import com.ufps.sgd.persistence.entity.Administrativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrativo")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping("/{id}")
    public Administrativo buscar(@PathVariable Long id) {
        return this.administrativoService.findById(id);
    }

    @GetMapping
    public List<Administrativo> listar() {
        return this.administrativoService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Administrativo administrativo) {
        this.administrativoService.save(administrativo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Administrativo administrativo) {
        administrativo.setId(id);
        this.administrativoService.save(administrativo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.administrativoService.deleteById(id);
    }
}
