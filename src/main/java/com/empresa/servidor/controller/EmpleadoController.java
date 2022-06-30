package com.empresa.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.servidor.entity.Empleado;
import com.empresa.servidor.service.EmpleadoService;
import com.empresa.servidor.utils.NotFoundException;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	@GetMapping("/lista")
	public List<Empleado> listar(){
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<Empleado> buscar(@PathVariable int id) throws Exception {
		Empleado prod = service.findById(id);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<Empleado>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/listaxNombres")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<List<Empleado>> buscar(@RequestParam String nombre) throws Exception {
		List<Empleado> prod = service.findAllByNombres(nombre);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<List<Empleado>>(prod, HttpStatus.OK);
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
