package com.nettdatademoweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nettdatademoweb.repository.entity.Empleado;
import com.nettdatademoweb.service.EmpleadoService;

@RestController
@RequestMapping ("/api/empleados")
public class EmpleadosRestController {

	@Autowired
	EmpleadoService empleadoservice;
	
	@GetMapping
	public List<Empleado> listarEmpleados(){
		
		return empleadoservice.listar();
	}
	
}