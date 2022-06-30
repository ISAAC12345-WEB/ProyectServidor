package com.empresa.servidor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empresa.servidor.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	@Query("select e from Empleado e where e.nombres like %?1%")
	public List<Empleado> findAllByNombresList(String nombres);
}
