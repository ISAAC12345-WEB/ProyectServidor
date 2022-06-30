package com.empresa.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.servidor.entity.Empleado;
import com.empresa.servidor.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;
	
	public List<Empleado> listAll(){
		return repository.findAll();
	}
	
	public Empleado findById(Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Empleado> findAllByNombres(String nombres){
		return repository.findAllByNombresList(nombres);
	}
	
	public void save(Empleado bean) {
		repository.save(bean);
	}
	
	public void update(Empleado bean) {
		repository.save(bean);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}
}
