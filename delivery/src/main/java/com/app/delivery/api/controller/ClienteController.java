package com.app.delivery.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Cliente;
import com.app.delivery.api.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRespository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRespository.findAll();
	}

}
