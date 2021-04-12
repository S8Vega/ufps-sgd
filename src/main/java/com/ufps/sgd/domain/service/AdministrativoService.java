package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.AdministrativoCrudRepository;
import com.ufps.sgd.persistence.entity.Administrativo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoCrudRepository administrativoCrudRepository;

    @Transactional(readOnly = true)
    public Administrativo findById(Long id) {
        return administrativoCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Administrativo> findAll() {
        return (List<Administrativo>) administrativoCrudRepository.findAll();
    }

    @Transactional
    public void save(Administrativo t) {
        administrativoCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        administrativoCrudRepository.deleteById(id);
    }
}
