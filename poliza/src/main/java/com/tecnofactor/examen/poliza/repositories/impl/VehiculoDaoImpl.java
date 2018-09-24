package com.tecnofactor.examen.poliza.repositories.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecnofactor.examen.poliza.entities.Vehiculo;
import com.tecnofactor.examen.poliza.integrations.PoliciaService;
import com.tecnofactor.examen.poliza.integrations.TallerAutorizadoService;
import com.tecnofactor.examen.poliza.repositories.VehiculoDao;
import com.tecnofactor.examen.poliza.repositories.exceptions.PoliciaServiceException;
import com.tecnofactor.examen.poliza.repositories.exceptions.TallerAutorizadoException;

@Repository
public class VehiculoDaoImpl implements VehiculoDao{
	
	@Autowired
	private PoliciaService policiaService;
	
	@Autowired
	private TallerAutorizadoService tallerAutorizadoService;

	@Override
	public Vehiculo buscarVehiculoRobado(String placa) throws PoliciaServiceException{
		if(placa == null) {
			throw new PoliciaServiceException("El número de la placa es incorrecto.");
		}
		Optional<Vehiculo> vehiculo = policiaService.obtenerVehiculosRobados().stream().filter(v -> v.getPlaca().equals(placa)).findFirst();  
		return  (vehiculo.isPresent()) ? vehiculo.get(): null;
	}

	@Override
	public Vehiculo buscarVehiculoInspeccionado(String placa) throws TallerAutorizadoException {
		if(placa == null) {
			throw new TallerAutorizadoException("El número de la placa es incorrecto.");
		}
		Optional<Vehiculo> vehiculo = tallerAutorizadoService.obtenerVehiculosInspeccionados().stream().filter(v -> v.getPlaca().equals(placa)).findFirst();  
		return  (vehiculo.isPresent()) ? vehiculo.get(): null;
	}
	
}
