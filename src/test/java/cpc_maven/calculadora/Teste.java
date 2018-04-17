package cpc_maven.calculadora;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cpc_maven.calculadora.screen.CalculatorScreen;

public class Teste {
	
	private static CalculatorScreen screen;
	
	@BeforeClass
	public static void tearUp() {
		screen = new CalculatorScreen();
	}
	
	@Test
	public void meuPrimeiroTesteFofo() {
		assertTrue("NÃO VOLTOU O NOME CASSIA", screen.getCassia().equals(" Cassia"));
	}
	
	@AfterClass
	public static void tearDown() {
		screen.encerrar();
	}

}
