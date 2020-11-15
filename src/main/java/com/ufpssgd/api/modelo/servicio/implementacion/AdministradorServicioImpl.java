package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IAdministradorDao;
import com.ufpssgd.api.modelo.entidad.Administrador;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class AdministradorServicioImpl implements IServicio<Administrador, Long> {

	@Autowired
	private IAdministradorDao administradorDao;

	@Override
	@Transactional(readOnly = true)
	public Administrador findById(Long id) {
		return administradorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Administrador> findAll() {
		return (List<Administrador>) administradorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Administrador t) {
		administradorDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		administradorDao.deleteById(id);
	}
}
