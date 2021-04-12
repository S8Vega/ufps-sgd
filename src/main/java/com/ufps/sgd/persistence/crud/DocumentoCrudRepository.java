package com.ufps.sgd.persistence.crud;

import com.ufps.sgd.persistence.entity.Documento;
import org.springframework.data.repository.CrudRepository;

public interface DocumentoCrudRepository extends CrudRepository<Documento, Long> {

}