package com.ufpssgd.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.ufpssgd.api.modelo.entidad.Documento;

public interface IDocumentoDao extends CrudRepository<Documento, Long> {

}