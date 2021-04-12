package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.RespuestaCrudRepository;
import com.ufps.sgd.persistence.entity.Respuesta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaCrudRepository respuestaCrudRepository;

    @Transactional(readOnly = true)
    public Respuesta findById(Long id) {
        return respuestaCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Respuesta> findAll() {
        return (List<Respuesta>) respuestaCrudRepository.findAll();
    }

    @Transactional
    public void save(Respuesta t) {
        respuestaCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        respuestaCrudRepository.deleteById(id);
    }
}
