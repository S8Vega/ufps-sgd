package com.ufps.sgd.persistence.crud;

import com.ufps.sgd.persistence.entity.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeCrudRepository extends CrudRepository<Mensaje, Long> {

}
