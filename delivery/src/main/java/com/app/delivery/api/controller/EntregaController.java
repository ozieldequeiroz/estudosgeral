package com.app.delivery.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.delivery.api.model.Entrega;
import com.app.delivery.api.service.SolicitacaoEntregaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	@Autowired
	private SolicitacaoEntregaService entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitacao(@Valid @RequestBody Entrega entrega) {
		return entregaService.solicitar(entrega);
	}

}
