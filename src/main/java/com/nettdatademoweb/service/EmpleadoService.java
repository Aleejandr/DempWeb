package com.nettdatademoweb.service;

import java.util.List;

import com.nettdatademoweb.repository.entity.Empleado;

public interface EmpleadoService {
	
	 void registrar(String name);
	
	 List<Empleado> listar();
	
	 List<Empleado> listarCuyoNombreContiene(String cad);
	
	 List<Empleado> listarConJPA(Integer pId , String contiene);
	 
	 List<Empleado> listarFiltroNombreEs(String cad);
	
	
		
		
	
	

}
