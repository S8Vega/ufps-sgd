package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.DependenciaCrudRepository;
import com.ufps.sgd.persistence.entity.Dependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DependenciaService {

    @Autowired
    private DependenciaCrudRepository dependenciaCrudRepository;

    @Transactional(readOnly = true)
    public Dependencia findById(Long id) {
        return dependenciaCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Dependencia> findAll() {
        return (List<Dependencia>) dependenciaCrudRepository.findAll();
    }

    @Transactional
    public void save(Dependencia t) {
        dependenciaCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        dependenciaCrudRepository.deleteById(id);
    }
}
