package com.app.delivery.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Cliente;
import com.app.delivery.api.repository.ClienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRespository;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRespository.findAll();
	}
	
	@GetMapping("/{clienteId}")
	public ResponseEntity<Cliente> pegarCliente(@PathVariable Long clienteId) {
		return clienteRespository.findById(clienteId)
				.map(cliente ->ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criaCliente(@Valid @RequestBody Cliente cliente) {
		return clienteRespository.save(cliente);
	}
	
	@PostMapping("/{clienteId}")
	public ResponseEntity<Cliente>atualiza(@Valid @PathVariable Long clienteId,@RequestBody Cliente cliente) {
		
		if(!clienteRespository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(clienteId);
		clienteRespository.save(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> excluir(@PathVariable Long clienteId){
		
		if(!clienteRespository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		clienteRespository.deleteById(clienteId);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
