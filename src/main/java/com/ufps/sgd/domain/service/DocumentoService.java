package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.DocumentoCrudRepository;
import com.ufps.sgd.persistence.entity.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoCrudRepository documentoCrudRepository;

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
}
