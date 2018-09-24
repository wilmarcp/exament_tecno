package com.tecnofactor.examen.poliza.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecnofactor.examen.poliza.repositories.VehiculoDao;
import com.tecnofactor.examen.poliza.repositories.exceptions.PoliciaServiceException;
import com.tecnofactor.examen.poliza.repositories.exceptions.TallerAutorizadoException;

@Entity
@Table(name ="TPOL_VEHICULO")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Size (max = 10, message = "La placa debe tener máximo {max} caracteres")
	@Column(name = "DS_PLACA", nullable = false)
	private String placa;
	
	@NotNull
	@Column(name = "NM_MODELO", nullable = false)
	private int modelo;
	
	@NotNull
	@Size (max = 30, message = "La marca del vehiculo debe tener máximo {max} caracteres")
	@Column(name = "DS_MARCA", nullable = false)
	private String marca;
	
	@NotNull
	@Column(name = "NM_CANTIDAD", nullable = false)
	private int cantidadPasajeros;

	@Transient
	@Autowired
	private VehiculoDao vehiculoDao;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantidadPasajeros() {
		return cantidadPasajeros;
	}

	public void setCantidadPasajeros(int cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
	}
	
	public void setVehiculoDao(VehiculoDao vehiculoDao) {
		this.vehiculoDao = vehiculoDao;
	}

	public boolean isInspeccionado() throws TallerAutorizadoException {
		Vehiculo vehiculo = vehiculoDao.buscarVehiculoInspeccionado(this.getPlaca()); 
		return vehiculo != null;
	}
	
	public boolean isRobado()  throws PoliciaServiceException  {
		Vehiculo vehiculo = vehiculoDao.buscarVehiculoRobado(this.getPlaca()); 
		return vehiculo != null;
	}
}
