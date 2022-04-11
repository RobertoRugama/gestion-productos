package com.gestion.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.productos.entidades.producto;

public interface ProductoRepositorio extends JpaRepository<producto,Long>{

	@Query("select p from producto p where "+ "CONCAT(p.id,p.nombre,p.marca,p.hechoEn,p.precio)"
	+"LIKE %?1%")
	public List<producto> findAll(String palabraClave);
}
