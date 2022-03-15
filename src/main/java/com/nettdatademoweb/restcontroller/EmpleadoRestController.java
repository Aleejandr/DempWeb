package com.nettdatademoweb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;
import org.springframework.http.HttpHeaders;

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
			Thread.sleep(500);
			
		} catch(InterruptedException e) {}
		
		return empleadoservice.listar();
	}
	
	/*
	@PostMapping
	@CacheEvict(value="empleados" , allEntries= true)
	public void insertarEmpleados(@RequestBody Empleado emp) {
		
		empleadoservice.inserta(emp);
	}
	*/
	
	/*
	@PostMapping
	@CacheEvict(value="empleados" , allEntries= true)
	public ResponseEntity<Empleado> insertarEmpleado_v2(@RequestBody Empleado emp){
		
		try {
			
			emp.setId(null);
			
			Empleado empDevuelto = empleadoservice.inserta(emp);
			return new ResponseEntity<> (empDevuelto , HttpStatus.CREATED);
			
		}catch(Exception ex) {
			return new ResponseEntity<> (null , HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	*/
	

@CacheEvict(value="empleados", allEntries=true)
	@PostMapping
	public ResponseEntity<Empleado> insertarEmpleado_v3 (@RequestBody Empleado empleado) {
		try {
			HttpHeaders headers = new HttpHeaders();
			if (empleado.getId()!=null) {
				headers.set("Message", "Para dar de alta un nuevo empleado, el ID debe llegar vacío");
				return new ResponseEntity<>(headers, HttpStatus.NOT_ACCEPTABLE);
			}
			else if (empleado.getNombre()==null || empleado.getNombre().equals("")
				|| empleado.getApellidos()==null || empleado.getApellidos().equals("")) {
				headers.set("Message", "Ni NOMBRE ni APELLIDOS pueden ser nulos");
				return new ResponseEntity<>(headers, HttpStatus.NOT_ACCEPTABLE);	
			}
			
			Empleado emp = empleadoservice.inserta(empleado);
			URI newPath = new URI("/api/empleados/"+emp.getId());
			headers.setLocation(newPath);
			headers.set("Message", "Empleado insertado correctamente con id: "+emp.getId());
			
			return new ResponseEntity<> (emp, headers, HttpStatus.CREATED);
		}
		catch (Exception ex) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	
	
	
	
	@PutMapping
	@CacheEvict(value="empleados" , allEntries= true)
	public Empleado modificarEmpleado(@RequestBody Empleado emp) {
		
		return empleadoservice.modificar(emp);
		
	}
		@DeleteMapping (value="/{id}")
		@CacheEvict(value="empleados" , allEntries= true)
		public void eliminarEmpleado(@PathVariable("id") Integer id) {
			
			empleadoservice.eliminar(id);
			
			
		}
		
		
		@GetMapping (value="/{id}")
		public ResponseEntity<Empleado> devuelveEmpleado(@PathVariable("id") Integer id){
			
			Empleado emp = empleadoservice.getById(id);
			
			if(emp==null)
				return new ResponseEntity<> (null, HttpStatus.NOT_FOUND);
			else
				 return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		
		
		
		
		
		
		
	
}
