package cpc_maven.calculadora.screen;

import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CalculatorScreen {
	
	
	@AndroidFindBy(id="botao")
	@iOSFindBy(accessibility="button")
	private RemoteWebElement remoteWebElement;
	
	
	public CalculatorScreen() {
		System.out.println("criou o objeto");
	}
	
	public String getCassia() {
		return " Cassia";
	}
	
	public void encerrar() {
		System.out.println("encerrar");
	}
}
