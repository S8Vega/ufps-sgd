package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.DepartamentoCrudRepository;
import com.ufps.sgd.persistence.entity.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoCrudRepository departamentoCrudRepository;

    @Transactional(readOnly = true)
    public Departamento findById(Long id) {
        return departamentoCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Departamento> findAll() {
        return (List<Departamento>) departamentoCrudRepository.findAll();
    }

    @Transactional
    public void save(Departamento t) {
        departamentoCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        departamentoCrudRepository.deleteById(id);
    }
}
