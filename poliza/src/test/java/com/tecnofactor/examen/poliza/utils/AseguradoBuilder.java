package com.tecnofactor.examen.poliza.utils;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.tecnofactor.examen.poliza.entities.Asegurado;

public class AseguradoBuilder {

	private String documento;
	private LocalDate fechaNacimiento; 
	private BigDecimal salario;
	private BigDecimal creditos;
	private BigDecimal gastos;
	
	public AseguradoBuilder() {
		this.fechaNacimiento = LocalDate.now().minusYears(20); 
		this.salario = new BigDecimal(1000000);
		this.creditos = BigDecimal.ZERO;
		this.gastos = BigDecimal.ZERO;
		this.documento = "123456789";
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public AseguradoBuilder conDocumento(String documento) {
		this.documento = documento;
		return this;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public AseguradoBuilder conFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public AseguradoBuilder conSalario(BigDecimal salario) {
		this.salario = salario;
		return this;
	}
	
	public BigDecimal getCreditos() {
		return creditos;
	}
	
	public AseguradoBuilder conCreditos(BigDecimal creditos) {
		this.creditos = creditos;
		return this;
	}
	
	public BigDecimal getGastos() {
		return gastos;
	}
	
	public AseguradoBuilder conGastos(BigDecimal gastos) {
		this.gastos = gastos;
		return this;
	}
	
	public Asegurado getAsegurado() {
		Asegurado asegurado = new Asegurado();
		asegurado.setCreditos(creditos);
		asegurado.setDocumento(documento);
		asegurado.setFechaNacimiento(fechaNacimiento);
		asegurado.setGastos(gastos);
		asegurado.setSalario(salario);
		
		return asegurado;
	}
	
}
