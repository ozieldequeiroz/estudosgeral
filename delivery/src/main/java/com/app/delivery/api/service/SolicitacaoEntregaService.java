package com.app.delivery.api.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private CatalogoClienteService clienteService;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		clienteService.buscar(entrega.getCliente().getId());
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
		return entregaRespository.save(entrega);
	}
}
