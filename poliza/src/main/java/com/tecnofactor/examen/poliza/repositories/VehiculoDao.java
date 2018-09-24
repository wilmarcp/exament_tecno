package com.tecnofactor.examen.poliza.repositories;

import com.tecnofactor.examen.poliza.entities.Vehiculo;
import com.tecnofactor.examen.poliza.repositories.exceptions.PoliciaServiceException;
import com.tecnofactor.examen.poliza.repositories.exceptions.TallerAutorizadoException;

public interface VehiculoDao {
	
	public Vehiculo buscarVehiculoRobado(String placa) throws PoliciaServiceException;
	
	public Vehiculo buscarVehiculoInspeccionado(String placa) throws TallerAutorizadoException ;

}
