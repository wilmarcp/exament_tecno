package com.tecnofactor.examen.poliza.utils;

import java.math.BigDecimal;

import com.tecnofactor.examen.poliza.entities.Poliza;

public class PolizaBuilder {
	
	
	private String numero;
	private BigDecimal valor;
	private boolean financiada;
	
	public PolizaBuilder() {
		this.numero = "123456789";
		this.valor = new BigDecimal(500);
		this.financiada = false;
	}

	public String getNumero() {
		return numero;
	}

	public PolizaBuilder conNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public PolizaBuilder conValor(BigDecimal valor) {
		this.valor = valor;
		return this;
	}
	
	public boolean isFinanciada() {
		return financiada;
	}

	public PolizaBuilder conFinanciada(boolean financiada) {
		this.financiada = financiada;
		return this;
	}

	public Poliza getPoliza() {
		Poliza poliza = new Poliza();
		poliza.setNumero(numero);
		poliza.setValor(valor);
		poliza.setFinanciada(financiada);
		return poliza;
	}
}
