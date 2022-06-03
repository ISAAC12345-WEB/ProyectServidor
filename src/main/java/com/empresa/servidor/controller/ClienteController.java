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

import com.empresa.servidor.entity.Cliente;
import com.empresa.servidor.service.ClienteService;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/lista") 
	public List<Cliente> listar(){
		return service.listAll();
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
