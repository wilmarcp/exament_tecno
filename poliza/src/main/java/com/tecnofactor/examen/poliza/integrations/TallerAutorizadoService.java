package com.tecnofactor.examen.poliza.integrations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tecnofactor.examen.poliza.entities.Vehiculo;

@Component
public class TallerAutorizadoService {

	public List<Vehiculo> obtenerVehiculosInspeccionados(){
		List<Vehiculo> vehiculos = new ArrayList<>();
		
		Vehiculo v1 = new Vehiculo();
		v1.setCantidadPasajeros(5);
		v1.setMarca("Hyiundai");
		v1.setModelo(2018);
		v1.setPlaca("DFU229");
		
		Vehiculo v2 = new Vehiculo();
		v2.setCantidadPasajeros(4);
		v2.setMarca("Chevrolet");
		v2.setModelo(2012);
		v2.setPlaca("JHR215");
		
		Vehiculo v3 = new Vehiculo();
		v3.setCantidadPasajeros(8);
		v3.setMarca("Mazda");
		v3.setModelo(2017);
		v3.setPlaca("PKD951");
		
		vehiculos.add(v3);
		vehiculos.add(v2);
		vehiculos.add(v1);
		
		return vehiculos;
	}
}
