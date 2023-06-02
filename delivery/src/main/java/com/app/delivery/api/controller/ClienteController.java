package com.app.delivery.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Cliente;
import com.app.delivery.api.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRespository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRespository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> pegarCliente(@PathVariable Long id) {
		return clienteRespository.findById(id)
				.map(cliente ->ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criaCliente(@RequestBody Cliente cliente) {
		return clienteRespository.save(cliente);
	}
}
