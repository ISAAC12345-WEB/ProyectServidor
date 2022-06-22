package com.empresa.servidor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdEmpleado")
	private int id;
	@Column(name = "Dni")
	private String dni;
	@Column(name = "Nombres")
	private String nombres;
	@Column(name = "Telefono")
	private String telefono;
	@Column(name = "Estado")
	private String estado;
	@Column(name = "User")
	private String user;
	
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dni=" + dni + ", nombres=" + nombres + ", telefono=" + telefono + ", estado="
				+ estado + ", user=" + user + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
