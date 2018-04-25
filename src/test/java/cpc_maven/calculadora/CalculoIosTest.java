package cpc_maven.calculadora;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import cpc_maven.calculadora.screen.CalculoScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class CalculoIosTest {
	
	private static CalculoScreen screen;
	private static AppiumDriver<RemoteWebElement> driver;
	
	@BeforeClass
	public static void 	caps() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app",new File("apps/SimpleCalculator.app"));
		capabilities.setCapability("deviceName", "iPhone 7");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "11.3");
		capabilities.setCapability("automationName" , "XCUITest");
		driver = new IOSDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		screen = new CalculoScreen(driver);
   }
	
	@Test
	public void soma() {
		screen.fillFirstNumber ("10");	
		screen.fillSecondNumber("20");
		screen.buttonSum.click();
		assertTrue("Valor esperado da Soma é 30.", screen.operationResult().equals("30"));
	}
	
	@Test
	public void subtracao() {
		screen.fillFirstNumber("50");
		screen.fillSecondNumber("35");
		screen.buttonSubt.click();
		assertTrue("Valor esperado da Subtração é 15.", screen.operationResult().equals("15"));
	}
	
	@Test
	public void multiplicacao() {
		screen.fillFirstNumber("9");
		screen.fillSecondNumber("9");
		screen.buttonMult.click();
		assertTrue("Valor esperado da Multiplicação é 81.", screen.operationResult().equals("81"));
	}
	
	@Test
	public void divisao() {
		screen.fillFirstNumber("150");
		screen.fillSecondNumber("2");
		screen.buttonDiv.click();
		assertTrue("Valor esperado da Divisão é 75.", screen.operationResult().equals("75"));
	}
	
	@AfterClass
	public static void encerra() {
		driver.quit();
	}
	

}
