package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IRespuestaDao;
import com.ufpssgd.api.modelo.entidad.Respuesta;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class RespuestaServicioImpl implements IServicio<Respuesta, Long> {

	@Autowired
	private IRespuestaDao respuestaDao;

	@Override
	@Transactional(readOnly = true)
	public Respuesta findById(Long id) {
		return respuestaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Respuesta> findAll() {
		return (List<Respuesta>) respuestaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Respuesta t) {
		respuestaDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		respuestaDao.deleteById(id);
	}
}
