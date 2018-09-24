package com.tecnofactor.examen.poliza.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

@Entity
@Table(name ="TPOL_POLIZA")
public class Poliza {

	@Id
	@Column(name = "DS_NUMERO", nullable = false)
	private String numero;
	
	@Min(value = 1, message = "El valor de la poliza debe ser mayor o igual a 1")
	@Column(name = "NM_VALOR", nullable = false)
	private BigDecimal valor;
	
	@Transient
	private boolean financiada;
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public boolean isFinanciada() {
		return financiada;
	}

	public void setFinanciada(boolean financiada) {
		this.financiada = financiada;
	}
	
}
