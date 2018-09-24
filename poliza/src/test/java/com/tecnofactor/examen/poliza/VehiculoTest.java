package com.tecnofactor.examen.poliza;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecnofactor.examen.poliza.entities.Vehiculo;
import com.tecnofactor.examen.poliza.repositories.VehiculoDao;
import com.tecnofactor.examen.poliza.repositories.exceptions.PoliciaServiceException;
import com.tecnofactor.examen.poliza.repositories.exceptions.TallerAutorizadoException;
import com.tecnofactor.examen.poliza.utils.VehiculoBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiculoTest {

	@Autowired
	private VehiculoDao vehiculoDao;
	
	@Test
	public void vehiculoInspecionadoOK()  throws TallerAutorizadoException{
		Vehiculo vehiculo = new VehiculoBuilder().getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		Assert.assertTrue(vehiculo.isInspeccionado());
	}
	
	@Test
	public void vehiculoNoInspeccionadoOK()  throws TallerAutorizadoException{
		Vehiculo vehiculo = new VehiculoBuilder().conPlaca("GTH568").getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		Assert.assertFalse(vehiculo.isInspeccionado());
	}
	
	@Test(expected = TallerAutorizadoException.class)
	public void vehiculoConPlacaNullFail()  throws TallerAutorizadoException{
		Vehiculo vehiculo = new VehiculoBuilder().conPlaca(null).getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		vehiculo.isInspeccionado();
	}
	
	@Test
	public void vehiculoRobadoOK()  throws PoliciaServiceException {
		Vehiculo vehiculo = new VehiculoBuilder().conPlaca("GHO741").getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		Assert.assertTrue(vehiculo.isRobado());
	}
	
	@Test
	public void vehiculoNoRobadoOK()  throws PoliciaServiceException {
		Vehiculo vehiculo = new VehiculoBuilder().conPlaca("AAA111").getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		Assert.assertFalse(vehiculo.isRobado());
	}
	
	@Test(expected = PoliciaServiceException.class)
	public void vehiculoConPlacaNullRobadoFail()  throws PoliciaServiceException {
		Vehiculo vehiculo = new VehiculoBuilder().conPlaca(null).getVehiculo();
		vehiculo.setVehiculoDao(vehiculoDao);
		Assert.assertFalse(vehiculo.isRobado());
	}
}
