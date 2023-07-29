package com.app.delivery.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.delivery.api.model.Entrega;
import com.app.delivery.api.repository.EntregaRepository;

@Service
public class SolicitacaoEntregaService {
	
	@Autowired
	private EntregaRepository entregaRespository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		return entregaRespository.save(entrega);
	}
}
