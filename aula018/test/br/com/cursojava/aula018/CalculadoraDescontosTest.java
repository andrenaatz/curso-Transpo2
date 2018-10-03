package br.com.cursojava.aula018;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraDescontosTest {
	
	CalculadoraDescontos calc;
	
	@Before
	public void inicio(){
		calc = new CalculadoraDescontos();
	}
	
	@Test
	public void testValoresNegativos(){
		double valor = -0.1;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(0, resultado, 0);
	}
	
	@Test
	public void testValoresPositivosAte1800Minimo(){
		double valor = 0.1;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(0.1, resultado, 0);
	}
	
	@Test
	public void testValoresPositivosAte1800Maximo(){
		double valor = 1800;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(1800, resultado, 0);
	}
	
	@Test
	public void testValoresPositivosNivel2Minimo(){
		double valor = 1800.01;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(1710.0095, resultado, 0);
	}
	
	@Test
	public void testValoresPositivosNivel2Maximo(){
		double valor = 2400;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(2280, resultado, 0);
	}
	
	@Test
	public void testValoresPositivosNivel3Minimo(){
		double valor = 2400.01;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(1872.0078, resultado, 0.1);
	}
	
	@Test
	public void testValoresPositivosNivel3Maximo(){
		double valor = 3599.99;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(2807.9922, resultado, 0.1);
	}
	
	@Test
	public void testValoresPositivosNivel4(){
		double valor = 3600;
		double resultado = calc.calcular(valor);
		Assert.assertEquals(2448, resultado, 0.1);
	}
	

}
