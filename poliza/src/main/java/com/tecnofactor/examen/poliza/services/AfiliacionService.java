package com.tecnofactor.examen.poliza.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnofactor.examen.poliza.entities.Afiliacion;
import com.tecnofactor.examen.poliza.entities.Asegurado;
import com.tecnofactor.examen.poliza.entities.Vehiculo;
import com.tecnofactor.examen.poliza.entities.exceptions.AfiliacionException;
import com.tecnofactor.examen.poliza.repositories.AfiliacionDao;
import com.tecnofactor.examen.poliza.repositories.AseguradoDao;
import com.tecnofactor.examen.poliza.repositories.VehiculoDao;
import com.tecnofactor.examen.poliza.repositories.exceptions.PoliciaServiceException;
import com.tecnofactor.examen.poliza.repositories.exceptions.TallerAutorizadoException;
import com.tecnofactor.examen.poliza.services.exceptions.AfiliacionServiceException;

@Service
public class AfiliacionService {

	@Autowired
	private VehiculoDao vehiculoDao;
	
	@Autowired
	private AseguradoDao aseguradoDao;
	
	@Autowired
	private AfiliacionDao afiliacionDao;
	
	public Afiliacion afiliar(Afiliacion afiliacion) throws AfiliacionServiceException{
		inicializarAfiliacion(afiliacion);
		validarAfiliacion(afiliacion);
		afiliacion.afiliar();
		return afiliacion;
	}

	private void inicializarAfiliacion(Afiliacion afiliacion) {
		afiliacion.getVehiculo().setVehiculoDao(vehiculoDao);
		afiliacion.setAfiliacionDao(afiliacionDao);
	}
	
	public void validarAfiliacion(Afiliacion afiliacion) throws AfiliacionServiceException{
		validarVehiculo(afiliacion.getVehiculo());
		validarAsegurado(afiliacion);
	}
	
	private void validarAsegurado(Afiliacion afiliacion) throws AfiliacionServiceException {
		Asegurado asegurado = consultarAseguradoPorDocumento(afiliacion.getAsegurado());
		afiliacion.setAsegurado(asegurado);
		try {
			afiliacion.validarEdadAsegurado();
			afiliacion.validarLiquidez();
		} catch (AfiliacionException e) {
			throw new AfiliacionServiceException("No se puede realizar la afiliacion porque el vehículo aun no ha sido inspeccionado.");
		}
	}
	
	private Asegurado consultarAseguradoPorDocumento(Asegurado asegurado) throws AfiliacionServiceException {
		Asegurado aseguradoConsultado = aseguradoDao.findById(asegurado.getDocumento()).orElse(null);
		if(aseguradoConsultado == null) {
			throw new AfiliacionServiceException("El asegurado no se encuentra registrado en el sistema");
		}
		return aseguradoConsultado;
	}

	private void validarVehiculo(Vehiculo vehiculo) throws AfiliacionServiceException{
		verificarVehiculoRobado(vehiculo);
		verificarVehiculoInspeccionado(vehiculo);
	}
	
	private void verificarVehiculoInspeccionado(Vehiculo vehiculo) throws AfiliacionServiceException {
		try {
			if(!vehiculo.isInspeccionado()) {
				throw new AfiliacionServiceException("No se puede realizar la afiliacion porque el vehículo aun no ha sido inspeccionado.");
			}
		}catch(TallerAutorizadoException e) {
			throw new AfiliacionServiceException("Error procesando la afiliacion", e);
		}
	}

	private void verificarVehiculoRobado(Vehiculo vehiculo) throws AfiliacionServiceException {
		try {
			if(vehiculo.isRobado()) {
				throw new AfiliacionServiceException("No se puede realizar la afiliacion porque el vehículo es robado.");
			}
		}catch(PoliciaServiceException e) {
			throw new AfiliacionServiceException("Error procesando la afiliacion", e);
		}
	}
}
