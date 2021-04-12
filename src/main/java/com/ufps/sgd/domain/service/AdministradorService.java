package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.AdministradorCrudRepository;
import com.ufps.sgd.persistence.entity.Administrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorCrudRepository administradorCrudRepository;

    @Transactional(readOnly = true)
    public Administrador findById(Long id) {
        return administradorCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return (List<Administrador>) administradorCrudRepository.findAll();
    }

    @Transactional
    public void save(Administrador t) {
        administradorCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        administradorCrudRepository.deleteById(id);
    }
}
