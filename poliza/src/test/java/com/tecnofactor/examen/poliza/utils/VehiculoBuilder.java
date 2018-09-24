package com.tecnofactor.examen.poliza.utils;

import com.tecnofactor.examen.poliza.entities.Vehiculo;

public class VehiculoBuilder {

	
	private String placa;
	private int modelo;
	private String marca;
	private int cantidadPasajeros;
	
	public VehiculoBuilder() {
		this.placa = "DFU229";
		this.modelo = 2012;
		this.marca = "Hyundai";
		this.cantidadPasajeros = 5;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public VehiculoBuilder conPlaca(String placa) {
		this.placa = placa;
		return this; 
	}
	
	public int getModelo() {
		return modelo;
	}
	
	public VehiculoBuilder conModelo(int modelo) {
		this.modelo = modelo;
		return this;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public VehiculoBuilder conMarca(String marca) {
		this.marca = marca;
		return this;
	}
	
	public int getCantidadPasajeros() {
		return cantidadPasajeros;
	}
	
	public VehiculoBuilder conCantidadPasajeros(int cantidadPasajeros) {
		this.cantidadPasajeros = cantidadPasajeros;
		return this;
	}
	
	public Vehiculo getVehiculo() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setCantidadPasajeros(this.cantidadPasajeros);
		vehiculo.setMarca(this.marca);
		vehiculo.setModelo(this.modelo);
		vehiculo.setPlaca(this.placa);
		return vehiculo;
	}
}
