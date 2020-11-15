package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IDocenteDao;
import com.ufpssgd.api.modelo.entidad.Docente;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class DocenteServicioImpl implements IServicio<Docente, Long> {

	@Autowired
	private IDocenteDao docenteDao;

	@Override
	@Transactional(readOnly = true)
	public Docente findById(Long id) {
		return docenteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll() {
		return (List<Docente>) docenteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Docente t) {
		docenteDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		docenteDao.deleteById(id);
	}
}
