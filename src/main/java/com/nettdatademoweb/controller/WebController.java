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
	EmpleadoService empleadoservi;
	
 	@GetMapping("/saludo")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mundo") 
							String name, Model model) {
		model.addAttribute("name", name);
		empleadoservi.registrar(name);
		return "hola";
	}
 	
 	
 	
 	@GetMapping("/error")
 	public String errorPage() {
 		return "error";
 	}

}
