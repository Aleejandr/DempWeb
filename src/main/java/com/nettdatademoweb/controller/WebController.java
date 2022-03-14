package com.nettdatademoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nettdatademoweb.repository.entity.Usuario;
import com.nettdatademoweb.service.EmpleadoService;

@Controller
public class WebController {
	
	
	@Autowired
	EmpleadoService empleadoservice;
	
	 @GetMapping("/")
		public String index (Model model) {
			Usuario u = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			model.addAttribute("usuario", u);
			return "index";
		}
	
	
 	@GetMapping("/saludo")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mundo") 
							String name, Model model) {
		model.addAttribute("name", name);
		empleadoservice.registrar(name);
		return "hola";
	}
 	
 	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
