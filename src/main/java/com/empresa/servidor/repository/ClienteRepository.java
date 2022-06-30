package com.empresa.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.servidor.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("select c from Cliente c where c.nombres like %?1%")
	public List<Cliente> findAllByNombresList(String nombres);
}
