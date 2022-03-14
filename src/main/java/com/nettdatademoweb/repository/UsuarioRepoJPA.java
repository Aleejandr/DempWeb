package com.nettdatademoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nettdatademoweb.repository.entity.Usuario;

public interface UsuarioRepoJPA extends JpaRepository<Usuario, String> {

}
