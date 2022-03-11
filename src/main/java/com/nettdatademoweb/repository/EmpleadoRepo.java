package com.nettdatademoweb.repository;

import java.util.List;

import com.nettdatademoweb.repository.entity.Empleado;

public interface EmpleadoRepo {
	
	public void registrar(String nombre);
	

	List<Empleado> listarCuyoNombreContiene(String texto_nombre);
	
}
