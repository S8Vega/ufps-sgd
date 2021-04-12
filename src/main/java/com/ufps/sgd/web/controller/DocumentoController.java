package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.DocumentoService;
import com.ufps.sgd.persistence.entity.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/{id}")
    public Documento buscar(@PathVariable Long id) {
        return this.documentoService.findById(id);
    }

    @GetMapping
    public List<Documento> listar() {
        return this.documentoService.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void crear(@RequestBody Documento documento) {
        this.documentoService.save(documento);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void actualizar(@PathVariable Long id, @RequestBody Documento documento) {
        documento.setId(id);
        this.documentoService.save(documento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        this.documentoService.deleteById(id);
    }
}
