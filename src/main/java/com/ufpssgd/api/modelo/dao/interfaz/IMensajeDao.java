package com.ufpssgd.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.ufpssgd.api.modelo.entidad.Mensaje;

public interface IMensajeDao extends CrudRepository<Mensaje, Long> {

}
