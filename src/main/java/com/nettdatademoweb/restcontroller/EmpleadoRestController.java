package com.nettdatademoweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nettdatademoweb.repository.entity.Empleado;
import com.nettdatademoweb.service.EmpleadoService;

@RestController
@RequestMapping ("/api/empleados")
public class EmpleadoRestController {

	@Autowired
	EmpleadoService empleadoservice;
	
	@GetMapping
	@Cacheable(value="empleados")
	public List<Empleado> listarEmpleados(){
		
		try {
			Thread.sleep(1500);
			
		} catch(InterruptedException e) {}
		
		return empleadoservice.listar();
	}
	
	
	@PostMapping
	@CacheEvict(value="empleados" , allEntries= true)
	public void insertarEmpleados(@RequestBody Empleado emp) {
		
		empleadoservice.inserta(emp);
	}
	
}
