package com.distribuida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.distribuida.dto.ClienteService;
import com.distribuida.entities.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService  clienteService;
	
	
	@GetMapping("/findAll")
	public String finAll(Model model) {
		
		List<Cliente> clientes = clienteService.findAll();
		model.addAttribute("clientes",clientes);
		
		return "clientes-listar";
	}
	
	@GetMapping("/findOne")
	public String findOne(@RequestParam("idCliente") @Nullable Integer idCliente
			, @RequestParam("opcion") @Nullable Integer opcion
			, Model model) {
		
		if(idCliente != null) {
			Cliente cliente = clienteService.findOne(idCliente);
			model.addAttribute("cliente",cliente);
		}
		if(opcion == 1) return "clientes-add";
		else return "clientes-del";
		
	}
	

}
