package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IDepartamentoDao;
import com.ufpssgd.api.modelo.entidad.Departamento;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class DepartamentoServicioImpl implements IServicio<Departamento, Long> {

	@Autowired
	private IDepartamentoDao departamentoDao;

	@Override
	@Transactional(readOnly = true)
	public Departamento findById(Long id) {
		return departamentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAll() {
		return (List<Departamento>) departamentoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Departamento t) {
		departamentoDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		departamentoDao.deleteById(id);
	}
}
