package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IDependenciaDao;
import com.ufpssgd.api.modelo.entidad.Dependencia;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class DependenciaServicioImpl implements IServicio<Dependencia, Long> {

	@Autowired
	private IDependenciaDao dependenciaDao;

	@Override
	@Transactional(readOnly = true)
	public Dependencia findById(Long id) {
		return dependenciaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Dependencia> findAll() {
		return (List<Dependencia>) dependenciaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Dependencia t) {
		dependenciaDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dependenciaDao.deleteById(id);
	}
}
