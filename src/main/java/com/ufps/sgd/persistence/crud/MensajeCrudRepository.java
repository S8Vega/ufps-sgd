package com.ufps.sgd.persistence.crud;

import com.ufps.sgd.persistence.entity.Mensaje;
import com.ufps.sgd.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MensajeCrudRepository extends CrudRepository<Mensaje, Long> {
    List<Mensaje> findByRemitente(Usuario remitente);

    List<Mensaje> findByReceptor(Usuario receptor);
}
