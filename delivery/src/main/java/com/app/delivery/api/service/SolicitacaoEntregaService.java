package com.app.delivery.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.delivery.api.exceptionhandler.NegocioException;
import com.app.delivery.api.model.Cliente;
import com.app.delivery.api.model.Entrega;
import com.app.delivery.api.model.StatusEntrega;
import com.app.delivery.api.repository.ClienteRepository;
import com.app.delivery.api.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRespository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow(()->new NegocioException("Cliente não encontrado"));
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		return entregaRespository.save(entrega);
	}
}
