package com.nettdatademoweb.service;

import java.util.List;

import com.nettdatademoweb.repository.entity.Usuario;

public interface UsuarioService {
	
	
	List<Usuario> listar();
	Usuario buscarPorUsername(String username);

}
