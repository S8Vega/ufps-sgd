package com.ufps.sgd.domain.service;

import com.ufps.sgd.persistence.crud.MensajeCrudRepository;
import com.ufps.sgd.persistence.crud.UsuarioCrudRepository;
import com.ufps.sgd.persistence.entity.Mensaje;
import com.ufps.sgd.persistence.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

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
        t.setContrasena(DigestUtils.md5DigestAsHex(t.getContrasena().getBytes()));
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

    @Override
    public UserDetails loadUserByUsername(String alias) throws UsernameNotFoundException {
        Usuario usuario = usuarioCrudRepository.findByAlias(alias);
        return new org.springframework.security.core.userdetails.User(usuario.getAlias(), "{noop}" + usuario.getContrasena(), new ArrayList<>());
    }
}
