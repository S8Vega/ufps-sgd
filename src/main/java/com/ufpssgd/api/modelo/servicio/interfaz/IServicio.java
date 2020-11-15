package com.ufpssgd.api.modelo.servicio.interfaz;

import java.util.List;

public interface IServicio<T, Id> {

	public T findById(Id id);

	public List<T> findAll();

	public void save(T t);

	public void deleteById(Id id);
}
