package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.distribuida.dto.LibroService;
import com.distribuida.entities.Libro;

@Controller
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Libro> libros = libroService.findAll();
		model.addAttribute("libros",libros);
		return "libro-listar";
	}
}
