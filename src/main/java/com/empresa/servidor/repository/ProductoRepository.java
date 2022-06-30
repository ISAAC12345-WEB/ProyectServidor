package com.empresa.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.servidor.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	@Query("select p from Producto p where p.nombres like %?1%")
	public List<Producto> findByProductName(String nombre);
}
