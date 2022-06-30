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

import com.empresa.servidor.entity.Producto;
import com.empresa.servidor.service.ProductoService;
import com.empresa.servidor.utils.NotFoundException;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/")
	public ResponseEntity<List<Producto>> listar() throws Exception {
		List<Producto> lista = service.listAll();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<Producto> buscar(@PathVariable int id) throws Exception {
		Producto prod = service.findById(id);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/listaxNombres")
	@CrossOrigin("http://localhost:8082")
	public ResponseEntity<List<Producto>> buscar(@RequestParam String nombre) throws Exception {
		List<Producto> prod = service.findByProductName(nombre);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<List<Producto>>(prod, HttpStatus.OK);
	}
	
	/*@GetMapping("/{productName}")
	public ResponseEntity<List<Producto>> listarporId(@PathVariable String productName) throws Exception {
		List<Producto> prod = service.findByProductName(productName);
		
		if(prod == null)
			throw new NotFoundException();
		
		return new ResponseEntity<List<Producto>>(prod, HttpStatus.OK);
	}*/
	
	@PostMapping("/")
	public ResponseEntity<Producto> registra(@RequestBody Producto producto) throws Exception {
		Producto prod = service.save(producto);
		return new ResponseEntity<Producto>(prod, HttpStatus.CREATED);
	}
	
	@PutMapping("/")
	public ResponseEntity<Producto> actualiza(@RequestBody Producto producto) throws Exception {
		Producto prod = service.findById(producto.getId());
		
		if(prod == null)
			throw new NotFoundException();
		else
			prod = service.update(producto);
		
		return new ResponseEntity<Producto>(prod, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> elimina(@PathVariable int id) throws Exception {
		Producto prod = service.findById(id);
		
		if(prod == null)
			throw new NotFoundException();
		else
			service.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
