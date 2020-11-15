package com.ufpssgd.api.modelo.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpssgd.api.modelo.dao.interfaz.IDocumentoDao;
import com.ufpssgd.api.modelo.entidad.Documento;
import com.ufpssgd.api.modelo.servicio.interfaz.IServicio;

@Service
public class DocumentoServicioImpl implements IServicio<Documento, Long> {

	@Autowired
	private IDocumentoDao documentoDao;

	@Override
	@Transactional(readOnly = true)
	public Documento findById(Long id) {
		return documentoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Documento> findAll() {
		return (List<Documento>) documentoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Documento t) {
		documentoDao.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		documentoDao.deleteById(id);
	}
}
