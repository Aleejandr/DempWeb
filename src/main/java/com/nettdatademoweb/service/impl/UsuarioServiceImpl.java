package com.nettdatademoweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nettdatademoweb.repository.UsuarioRepoJPA;
import com.nettdatademoweb.repository.entity.Usuario;
import com.nettdatademoweb.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	
	@Autowired
	UsuarioRepoJPA usuarioDAO;
	
	@Override
	public List<Usuario> listar() {
		
		return usuarioDAO.findAll();
	}

	@Override
	public Usuario buscarPorUsername(String username) {
		
		return usuarioDAO.findById(username).get();
	}

}
