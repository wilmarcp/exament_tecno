package com.tecnofactor.examen.poliza;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tecnofactor.examen.poliza.entities.Afiliacion;
import com.tecnofactor.examen.poliza.entities.Asegurado;
import com.tecnofactor.examen.poliza.entities.Poliza;
import com.tecnofactor.examen.poliza.entities.exceptions.AfiliacionException;
import com.tecnofactor.examen.poliza.utils.AseguradoBuilder;
import com.tecnofactor.examen.poliza.utils.PolizaBuilder;

public class AfiliacionTest {

	private Poliza poliza;
	private Asegurado asegurado;
	private Afiliacion afiliacion;
	
	@Before
	public void setUp() {
		this.poliza = new PolizaBuilder().getPoliza();
		this.asegurado = new AseguradoBuilder().getAsegurado();
		this.afiliacion = new Afiliacion();
		this.afiliacion.setAsegurado(asegurado);
		this.afiliacion.setPoliza(poliza);
	}
	
	@Test
	public void tieneLiquidezOk() {
		Assert.assertTrue(this.afiliacion.tieneLiquidez());
	}
	
	@Test
	public void noLiquidezOk() {
		this.asegurado = new AseguradoBuilder().conGastos(new BigDecimal(1000000)).conCreditos(new BigDecimal(100000)).getAsegurado();
		this.poliza = new PolizaBuilder().conValor(new BigDecimal(5000000)).getPoliza();
		this.afiliacion.setAsegurado(this.asegurado);
		this.afiliacion.setPoliza(this.poliza);
		Assert.assertFalse(this.afiliacion.tieneLiquidez());
	}
	
	@Test(expected = AfiliacionException.class)
	public void validarLiquidezFail() throws AfiliacionException {
		this.asegurado = new AseguradoBuilder().conGastos(new BigDecimal(1000000)).conCreditos(new BigDecimal(100000)).getAsegurado();
		this.poliza = new PolizaBuilder().conValor(new BigDecimal(5000000)).conFinanciada(true).getPoliza();
		this.afiliacion.setAsegurado(this.asegurado);
		this.afiliacion.setPoliza(this.poliza);
		this.afiliacion.validarLiquidez();
	}
	
	@Test
	public void validarEdadAseguradoOK() throws AfiliacionException {
		this.asegurado = new AseguradoBuilder().getAsegurado();
		this.afiliacion.setAsegurado(this.asegurado);
		this.afiliacion.validarEdadAsegurado();
	}
	
	@Test(expected = AfiliacionException.class)
	public void validarEdadAseguradoFail() throws AfiliacionException {
		this.asegurado = new AseguradoBuilder().conFechaNacimiento(LocalDate.now().minusYears(15)). getAsegurado();
		this.afiliacion.setAsegurado(this.asegurado);
		this.afiliacion.validarEdadAsegurado();
	}
}
