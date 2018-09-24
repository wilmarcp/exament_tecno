package com.tecnofactor.examen.poliza.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name ="TPOL_ASEGURADO")
public class Asegurado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size (max = 15, message = "El documento debe tener máximo {max} caracteres")
	@Pattern (regexp = "^[0-9]*$", message = "El documento tiene un formato inválido")
	@Column(name = "DS_DOCUMENTO")
	private String documento;
	
	@NotNull
	@Column(name = "FE_NACIMIENTO")
	private LocalDate fechaNacimiento; 
	
	@NotNull
	@Min(value = 1, message = "El salario del asegurado debe ser superior a 1")
	@Column(name = "NM_SALARIO")
	private BigDecimal salario;
	
	@NotNull
	@Min(value = 0, message = "Los creditos totales del asegurado deben ser mayor o igual a cero")
	@Column(name = "NM_CREDITOS")
	private BigDecimal creditos;
	
	@NotNull
	@Min(value = 0, message = "Los gastos totales del asegurado deben ser mayor o igual a cero")
	@Column(name = "NM_GASTOS_FIJOS")
	private BigDecimal gastos;
	
	public double calcularExcesoMensual() {
		return this.salario.subtract(this.creditos).subtract(this.gastos).doubleValue();
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getCreditos() {
		return creditos;
	}

	public void setCreditos(BigDecimal creditos) {
		this.creditos = creditos;
	}

	public BigDecimal getGastos() {
		return gastos;
	}

	public void setGastos(BigDecimal gastos) {
		this.gastos = gastos;
	}
	
	public boolean isMayorDeEdad() {
		return this.getFechaNacimiento().plusYears(18).isBefore(LocalDate.now());
	}
	
}
