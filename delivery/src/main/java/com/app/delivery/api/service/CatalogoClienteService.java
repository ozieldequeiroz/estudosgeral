package com.app.delivery.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.delivery.api.model.Cliente;
import com.app.delivery.api.repository.ClienteRepository;

@Service
public class CatalogoClienteService {

	private ClienteRepository clienteRepository;
	
	public CatalogoClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
		.stream()
		.anyMatch(clienteExistente->!clienteExistente.equals(cliente));
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		 clienteRepository.deleteById(clienteId);
	}

}
