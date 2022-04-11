package com.gestion.productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.productos.entidades.producto;
import com.gestion.productos.servicio.ProductoServicio;

@Controller
public class ProductoControlador {
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@RequestMapping("/")
	public String verPaginaDeInicio(Model modelo, @Param("palabraClave") String palabraClave) {
		List<producto> listaProductos = productoServicio.ListAll(palabraClave);	
		modelo.addAttribute("listarProductos", listaProductos);
		modelo.addAttribute("listarProductos",listaProductos);
		return "Index";
	}
	
	@RequestMapping("/nuevo")
	public String FormularioRegistrar(Model modelo) {
		producto prod = new producto();
		modelo.addAttribute("producto", prod);
		return "nuevo_producto";
	}
	
	@RequestMapping(value="/guardar", method = RequestMethod.POST)
	public String GuardarProducto(@ModelAttribute("producto") producto prod) {
		productoServicio.save(prod);
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView EditarFormuario(@PathVariable(name ="id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_producto");
		producto prod = productoServicio.get(id);
		modelo.addObject("producto", prod);
		return modelo;
	
	}
	
	@RequestMapping("/eliminar/{id}")
	public String EliminarProducto(@PathVariable(name ="id") Long id) {
		productoServicio.delete(id);
		return "redirect:/";
	}
	
	
	
}
