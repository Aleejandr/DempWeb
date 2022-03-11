package com.nettdatademoweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nettdatademoweb.repository.entity.Empleado;

public interface EmpleadoRepoJPA extends JpaRepository<Empleado, Integer> , EmpleadoRepo {
	
 
	List<Empleado> findByIdGreaterThanAndNombreLike(Integer pId , String Contiene);
	
	@Query(value="select * from empleado where nombre=?1", nativeQuery=true)
	List<Empleado> listarCuyoNombreEs(String nombre);
	

}
