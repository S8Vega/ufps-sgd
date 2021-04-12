package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.MensajeCrudRepository;
import com.ufps.sgd.persistence.entity.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MensajeService {

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    @Transactional(readOnly = true)
    public Mensaje findById(Long id) {
        return mensajeCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Mensaje> findAll() {
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    @Transactional
    public void save(Mensaje t) {
        mensajeCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        mensajeCrudRepository.deleteById(id);
    }
}
