package com.tecnofactor.examen.poliza.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.tecnofactor.examen.poliza.entities.exceptions.AfiliacionException;
import com.tecnofactor.examen.poliza.repositories.AfiliacionDao;

@Entity
@Table(name = "TPOL_AFILIACION")
public class Afiliacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NM_ID")
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DS_DOCUMENTO_ASEGURADO", nullable = false)
	private Asegurado asegurado;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "DS_NUMERO_POLIZA", nullable = false)
	private Poliza poliza;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DS_PLACA_VEHICULO", nullable = false)
	private Vehiculo vehiculo;
	
	@Transient
	private AfiliacionDao afiliacionDao;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Asegurado getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public void setAfiliacionDao(AfiliacionDao afiliacionDao) {
		this.afiliacionDao = afiliacionDao;
	}

	public void validarLiquidez() throws AfiliacionException {
		if(this.getPoliza().isFinanciada() && !tieneLiquidez()) {
			throw new AfiliacionException("No se puede realizar a afilicacion del vehiculo porque el asegurado no tiene liquidez");
		}
	}
	
	public void validarEdadAsegurado() throws AfiliacionException {
		if(!this.getAsegurado().isMayorDeEdad()) {
			throw new AfiliacionException("El asegurado aún no es mayor de edad");
		}
	}

	public boolean tieneLiquidez() {
		double cuotaMensual = this.poliza.getValor().doubleValue() /  11;
		double excesoMensual = this.asegurado.calcularExcesoMensual();
		return excesoMensual > cuotaMensual;
	}
	
	public void afiliar() {
		afiliacionDao.save(this);
	}
	
}
