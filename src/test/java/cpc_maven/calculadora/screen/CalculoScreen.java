package cpc_maven.calculadora.screen;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CalculoScreen {
	
	public CalculoScreen(AppiumDriver<RemoteWebElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android_field_first_number")
	@iOSFindBy(accessibility="apple_first_input")
	private RemoteWebElement inputFirstNumber;
	
	@AndroidFindBy(id="android_field_second_number")
	@iOSFindBy(accessibility="apple_second_input")
	private RemoteWebElement inputSecondNumber;
	
	@AndroidFindBy(id="android_button_sum")
	@iOSFindBy(accessibility="apple-sum-button")
	public RemoteWebElement buttonSum;
	
	@AndroidFindBy(id="android_button_sub")
	@iOSFindBy(accessibility="apple-subtract-button")
	public RemoteWebElement buttonSubt;
	
	@AndroidFindBy(id="android_button_mult")
	@iOSFindBy(accessibility="apple-multiply-button")
	public RemoteWebElement buttonMult;
	
	@AndroidFindBy(id="android_button_div")
	@iOSFindBy(accessibility="apple-divide-button")
	public RemoteWebElement buttonDiv;
	
	@AndroidFindBy(id="android_result_text")
	@iOSFindBy(accessibility="apple_result_text")
	private RemoteWebElement resultText;

	
	public void fillFirstNumber(String number) {
		inputFirstNumber.clear();
		inputFirstNumber.sendKeys(number);
	}
	
	public void fillSecondNumber(String number) {
		inputSecondNumber.clear();
		inputSecondNumber.sendKeys(number);
	}

	public String operationResult() {
		return resultText.getText().toString().trim();
	}
	
}
