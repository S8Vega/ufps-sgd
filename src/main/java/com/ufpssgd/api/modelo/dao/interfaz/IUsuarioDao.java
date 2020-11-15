package com.ufpssgd.api.modelo.dao.interfaz;

import org.springframework.data.repository.CrudRepository;

import com.ufpssgd.api.modelo.entidad.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

}
