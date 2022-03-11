package com.nettdatademoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettdatademoweb.repository.EmpleadoRepo;
import com.nettdatademoweb.repository.EmpleadoRepoJPA;
import com.nettdatademoweb.repository.entity.Empleado;
import com.nettdatademoweb.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	

	
	
	@Autowired
	EmpleadoRepoJPA empleadorepo;
	

	@Override
	public void registrar(String name) {
		
		empleadorepo.registrar(name);
		
		
	}

	@Override
	public List<Empleado> listar() {
		// TODO Auto-generated method stub
		return empleadorepo.findAll();
	}

	@Override
	public List<Empleado> listarCuyoNombreContiene(String cad) {
		// TODO Auto-generated method stub
		return empleadorepo.listarCuyoNombreContiene(cad);
	}

	@Override
	public List<Empleado> listarConJPA(Integer pId, String contiene) {
		
		
		return empleadorepo.findByIdGreaterThanAndNombreLike(pId, contiene);
	}

	@Override
	public List<Empleado> listarFiltroNombreEs(String cad) {
		
		
		return  empleadorepo.listarCuyoNombreEs(cad);
	}

	@Override
	public Empleado inserta(Empleado emp) {
		
		return empleadorepo.save(emp);
	}
	
	
	

}
