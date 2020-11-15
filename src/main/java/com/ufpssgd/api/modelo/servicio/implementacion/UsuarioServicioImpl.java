package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IUsuarioDao;
import com.ufpssgd.api.modelo.entidad.Usuario;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class UsuarioServicioImpl implements IServicio<Usuario, Long> {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario t) {
		usuarioDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
	}
}
