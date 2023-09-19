package com.app.delivery.api.representationmodel;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.app.delivery.api.model.StatusEntrega;

public class EntregaModel {
	private Long id;
	private String nomeCliente;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;

}
