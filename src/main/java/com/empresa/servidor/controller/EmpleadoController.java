package com.empresa.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.empresa.servidor.entity.Empleado;
import com.empresa.servidor.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	@GetMapping("/lista")
	public List<Empleado> listar(){
		return service.listAll();
	}
	
	@PostMapping("/registra")
	public void registra(@RequestBody Empleado empleado) {
		service.save(empleado);
	}
	
	@PutMapping("/actualiza")
	public void actualiza(@RequestBody Empleado empleado) {
		service.update(empleado);
	}
	
	@DeleteMapping("/elimina/{id}")
	public void elimina(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}
