package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.EtiquetaCrudRepository;
import com.ufps.sgd.persistence.entity.Etiqueta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaCrudRepository etiquetaCrudRepository;

    @Transactional(readOnly = true)
    public Etiqueta findById(Long id) {
        return etiquetaCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Etiqueta> findAll() {
        return (List<Etiqueta>) etiquetaCrudRepository.findAll();
    }

    @Transactional
    public void save(Etiqueta t) {
        etiquetaCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        etiquetaCrudRepository.deleteById(id);
    }
}
