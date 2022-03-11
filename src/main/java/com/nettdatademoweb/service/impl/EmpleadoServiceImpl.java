package com.nettdatademoweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettdatademoweb.repository.EmpleadoRepo;
import com.nettdatademoweb.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	
	
	@Autowired
	EmpleadoRepo empleadorepo;

	@Override
	public void registrar(String name) {
		
		empleadorepo.registrar(name);
		
		
	}
	
	
	

}
