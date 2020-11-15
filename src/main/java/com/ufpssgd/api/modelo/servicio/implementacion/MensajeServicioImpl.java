package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IMensajeDao;
import com.ufpssgd.api.modelo.entidad.Mensaje;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class MensajeServicioImpl implements IServicio<Mensaje, Long> {

	@Autowired
	private IMensajeDao mensajeDao;

	@Override
	@Transactional(readOnly = true)
	public Mensaje findById(Long id) {
		return mensajeDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mensaje> findAll() {
		return (List<Mensaje>) mensajeDao.findAll();
	}

	@Override
	@Transactional
	public void save(Mensaje t) {
		mensajeDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		mensajeDao.deleteById(id);
	}
}
