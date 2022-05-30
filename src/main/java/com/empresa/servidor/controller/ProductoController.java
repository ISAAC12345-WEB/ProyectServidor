package com.empresa.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.servidor.entity.Producto;
import com.empresa.servidor.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/lista")
	public List<Producto> listar(){
		return service.listAll();
	}
	
	@PostMapping("/registra")
	public void registra(@RequestBody Producto producto) {
		service.save(producto);
	}
}
