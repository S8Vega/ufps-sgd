package com.ufps.sgd.domain.service;

import com.ufps.sgd.domain.exception.FileStorageException;
import com.ufps.sgd.domain.exception.MyFileNotFoundException;
import com.ufps.sgd.domain.property.FileStorageProperties;
import com.ufps.sgd.persistence.crud.DocumentoCrudRepository;
import com.ufps.sgd.persistence.entity.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class DocumentoService {

    private final Path fileStorageLocation;

    @Autowired
    private DocumentoCrudRepository documentoCrudRepository;

    @Autowired
    public DocumentoService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Transactional(readOnly = true)
    public Documento findById(Long id) {
        return documentoCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Documento> findAll() {
        return (List<Documento>) documentoCrudRepository.findAll();
    }

    @Transactional
    public void save(Documento t) {
        documentoCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        documentoCrudRepository.deleteById(id);
    }

    public void guardarArchivo(Long id, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("El nombre del archivo es invalido: " + fileName);
            }
            Documento documento = this.findById(id);
            documento.setNombre(fileName);
            this.save(documento);
            fileName = Long.toString(id);
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new FileStorageException("No se puede guardar el archivo " + fileName + ". por favor intente de nuevo", ex);
        }
    }

    public Resource cargarArchivo(Long id) {
        try {
            Documento documento = this.findById(id);
            Path filePath = this.fileStorageLocation.resolve(Long.toString(id)).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Archivo no encontrado");
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Archivo no encontrado", ex);
        }
    }
}
