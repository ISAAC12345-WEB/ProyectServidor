package com.empresa.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.servidor.entity.Producto;
import com.empresa.servidor.repository.ProductoRepository;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoRepository repository;
	
	public List<Producto> listAll(){
		return repository.findAll();
	}
	
	public Producto findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public Producto save(Producto bean) {
		return repository.save(bean);
	}
	
	public Producto update(Producto bean) {
		return repository.save(bean);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
