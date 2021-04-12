package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.MensajeCrudRepository;
import com.ufps.sgd.persistence.crud.UsuarioCrudRepository;
import com.ufps.sgd.persistence.entity.Mensaje;
import com.ufps.sgd.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioCrudRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioCrudRepository.findAll();
    }

    @Transactional
    public void save(Usuario t) {
        usuarioCrudRepository.save(t);
    }

    @Transactional
    public void deleteById(Long id) {
        usuarioCrudRepository.deleteById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Mensaje> findByRemitente(Long id) {
        return this.mensajeCrudRepository.findByRemitente(findById(id));
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Mensaje> findByReceptor(Long id) {
        return this.mensajeCrudRepository.findByReceptor(findById(id));
    }
}
