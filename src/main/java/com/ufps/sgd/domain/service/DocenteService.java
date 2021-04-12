package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.DocenteCrudRepository;
import com.ufps.sgd.persistence.entity.Docente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteCrudRepository docenteCrudRepository;

    @Transactional(readOnly = true)
    public Docente findById(Long id) {
        return docenteCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Docente> findAll() {
        return (List<Docente>) docenteCrudRepository.findAll();
    }

    @Transactional
    public void save(Docente t) {
        docenteCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        docenteCrudRepository.deleteById(id);
    }
}
