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
import io.appium.java_client.android.AndroidDriver;

public class CalculoAndroidTest {
	
	private static CalculoScreen screen;
	private static AppiumDriver<RemoteWebElement> driver;
	
	@BeforeClass
	public static void 	caps() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app",new File("apps/calculadora-simples-android.apk"));
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("unicodeKeyboard", true);
		driver = new AndroidDriver<RemoteWebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		screen = new CalculoScreen(driver);
	
   }
	
	@Test
	public void soma() {
		screen.fillFirstNumber ("5");	
		screen.fillSecondNumber("10");
		screen.buttonSum.click();
		assertTrue("Valor da Soma é diferente de 15.", screen.operationResult().equals("15"));
	}
	
	@Test
	public void subtracao() {
		screen.fillFirstNumber("25");
		screen.fillSecondNumber("35");
		screen.buttonSubt.click();
		assertTrue("Valor da Subtração é diferente de -10.", screen.operationResult().equals("-10"));
	}
	
	@Test
	public void multiplicacao() {
		screen.fillFirstNumber("8");
		screen.fillSecondNumber("9");
		screen.buttonMult.click();
		assertTrue("Valor da Multiplicação é diferente de 72.", screen.operationResult().equals("72"));
	}
	
	@Test
	public void divisao() {
		screen.fillFirstNumber("350");
		screen.fillSecondNumber("25");
		screen.buttonDiv.click();
		assertTrue("Valor da Divisão é diferente de 14.", screen.operationResult().equals("14"));
	}
	
	@AfterClass
	public static void encerra() {
		driver.quit();
	}
	
}
