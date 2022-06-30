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

import com.empresa.servidor.entity.Cliente;
import com.empresa.servidor.service.ClienteService;
import com.empresa.servidor.utils.NotFoundException;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/lista") 
	public List<Cliente> listar(){
		return service.listAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<Cliente> buscar(@PathVariable int id) throws Exception {
		Cliente prod = service.findById(id);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<Cliente>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/listaxNombres")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<List<Cliente>> buscar(@RequestParam String nombre) throws Exception {
		List<Cliente> prod = service.findAllByNombres(nombre);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<List<Cliente>>(prod, HttpStatus.OK);
	}
	
	@PostMapping("/registra")
	public void registra(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
	
	@PutMapping("/actualiza")
	public void actualiza(@RequestBody Cliente cliente) {
		service.update(cliente);
	}
	
	@DeleteMapping("/eliminia/{id}")
	public void eliminia(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}
