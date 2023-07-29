package com.app.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Entrega;
import com.app.delivery.api.service.SolicitacaoEntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService entregaService;
	
	@PostMapping
	public Entrega solicitacao(Entrega entrega) {
		return entregaService.solicitar(entrega);
	}

}
