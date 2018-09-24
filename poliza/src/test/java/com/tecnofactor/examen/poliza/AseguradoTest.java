package com.tecnofactor.examen.poliza;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecnofactor.examen.poliza.entities.Asegurado;
import com.tecnofactor.examen.poliza.utils.AseguradoBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AseguradoTest {

//	@Autowired
//	private Asegurado asegurado;
	
	@Test
	public void calculoExcesoMensualAseguradoOk() {
		Asegurado asegurado =  new AseguradoBuilder().conCreditos(new BigDecimal(100000)).conGastos(new BigDecimal(200000)).getAsegurado();
		double excesoMensual = asegurado.calcularExcesoMensual();
		Assert.assertEquals(700000, excesoMensual, 0);
	}
}
