package com.gestion.productos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.productos.entidades.producto;
import com.gestion.productos.repository.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	public List<producto> ListAll(String palabraClave){
		if(palabraClave != null) {
		return productoRepositorio.findAll(palabraClave);
		}
		return	productoRepositorio.findAll();
		
	}
	
	public void save(producto prod) {
		productoRepositorio.save(prod);
	}
	
	public producto get(Long id) {
		return productoRepositorio.findById(id).get();
	}
	
	public void delete (Long id) {
		productoRepositorio.deleteById(id);
	}
	
	
}
