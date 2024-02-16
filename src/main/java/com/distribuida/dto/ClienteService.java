package com.distribuida.dto;

import java.util.List;

import com.distribuida.entities.Cliente;

public interface ClienteService {

	public List<Cliente> findAll();
	
	public Cliente findOne(int id);
	
	public void add(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono,
			String correo);
	
	public void up(int idCliente, String cedula, String nombre, String apellido, String direccion, String telefono,
			String correo);
	
	public void del(int id);
	
}
