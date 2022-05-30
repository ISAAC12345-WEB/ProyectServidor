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
	
	public void save(Producto bean) {
		repository.save(bean);
	}
}
