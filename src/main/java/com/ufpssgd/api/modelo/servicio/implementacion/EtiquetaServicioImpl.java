package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IEtiquetaDao;
import com.ufpssgd.api.modelo.entidad.Etiqueta;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class EtiquetaServicioImpl implements IServicio<Etiqueta, Long> {

	@Autowired
	private IEtiquetaDao etiquetaDao;

	@Override
	@Transactional(readOnly = true)
	public Etiqueta findById(Long id) {
		return etiquetaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Etiqueta> findAll() {
		return (List<Etiqueta>) etiquetaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Etiqueta t) {
		etiquetaDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		etiquetaDao.deleteById(id);
	}
}
