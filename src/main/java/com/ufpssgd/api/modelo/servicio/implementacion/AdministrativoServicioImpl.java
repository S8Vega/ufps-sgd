package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IAdministrativoDao;
import com.ufpssgd.api.modelo.entidad.Administrativo;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class AdministrativoServicioImpl implements IServicio<Administrativo, Long> {

	@Autowired
	private IAdministrativoDao administrativoDao;

	@Override
	@Transactional(readOnly = true)
	public Administrativo findById(Long id) {
		return administrativoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Administrativo> findAll() {
		return (List<Administrativo>) administrativoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Administrativo t) {
		administrativoDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		administrativoDao.deleteById(id);
	}
}
