package com.app.delivery.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Joaõ dos nomes");
		cliente1.setTelefone("83 956321477");
		cliente1.setEmail("joaodosnomes@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("beatriz sara");
		cliente2.setTelefone("83 852321865");
		cliente2.setEmail("beatrizsara@gmail.com");

		
		return Arrays.asList(cliente1,cliente2);
	}

}
