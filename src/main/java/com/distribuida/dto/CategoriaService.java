package com.distribuida.dto;

import java.util.List;

import com.distribuida.entities.Autor;
import com.distribuida.entities.Categoria;

public interface CategoriaService {

	public List<Categoria> findAll();
	
	public Categoria findOne(int id);
	
	public void add(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo);
	
	public void up(int idAutor, String nombre, String apellido, String pais, String direccion, String telefono,
			String correo);
	
	public void del(int id);
	
	public List<Categoria> findAll(String busqueda);
	
}
