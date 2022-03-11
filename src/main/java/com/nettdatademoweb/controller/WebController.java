package com.nettdatademoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nettdatademoweb.service.EmpleadoService;

@Controller
public class WebController {
	
	
	@Autowired
	EmpleadoService empleadoservice;
	
 	@GetMapping("/saludo")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mundo") 
							String name, Model model) {
		model.addAttribute("name", name);
		empleadoservice.registrar(name);
		return "hola";
	}
 	
 	@GetMapping("/listarEmpleados")
 	public String listarEmp(Model model) {
 		
 		model.addAttribute("listaEmp" , empleadoservice.listar());
 		model.addAttribute("listaEmpConE" , empleadoservice.listarCuyoNombreContiene("e"));
 		model.addAttribute("listaJPA" , empleadoservice.listarConJPA(2, "%o%"));
 		model.addAttribute("listaEmpNombreExacto" , empleadoservice.listarFiltroNombreEs("Rocío"));
 		
 		return "listarDeEmpleados";
 	}
 	
 	

 	
 	@GetMapping("/error")
 	public String errorPage() {
 		return "error";
 	}

}
