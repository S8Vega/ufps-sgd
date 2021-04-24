package com.ufps.sgd.web.controller;

import com.ufps.sgd.domain.service.DocumentoService;
import com.ufps.sgd.persistence.entity.Documento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    private static final Logger logger = LoggerFactory.getLogger(DocumentoController.class);
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

    @PostMapping("/{id}/archivo")
    public void cargarArchivo(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        documentoService.guardarArchivo(id, file);
    }

    @GetMapping("{id}/descargar")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id, HttpServletRequest request) {
        Resource resource = documentoService.cargarArchivo(id);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        Documento documento = documentoService.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documento.getNombre() + "\"")
                .body(resource);
    }
}
