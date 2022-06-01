package com.empresa.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.servidor.entity.Cliente;
import com.empresa.servidor.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> listAll(){
		return repository.findAll();
	}
	
	public void save(Cliente bean) {
		repository.save(bean);
	}
	
	public void update(Cliente bean) {
		repository.save(bean);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}
