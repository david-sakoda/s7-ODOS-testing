package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	
	@FindBy(xpath = "//*[@id='firstName']")
	public WebElement registrationPageFirstNameInput;
	
	@FindBy(xpath = "//*[@id='lastName']")
	public WebElement registrationPageLastNameInput;
	
	@FindBy(xpath = "//*[@id='email']")
	public WebElement registrationPageEmailInput;
	
	@FindBy(xpath = "//*[@id='password']")
	public WebElement registrationPagePasswordInput;
	
	@FindBy(xpath = "//*[@id='password-confirm']")
	public WebElement registrationPageConfirmPasswordInput;
	
	@FindBy(xpath = "//*[@id='group']")
	public WebElement registrationPageGroupDropdown;
	
	@FindBy(xpath = "//*[@id='kc-form-options']//a")
	public WebElement registrationPageBackButton;
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement registrationPageRegisterButton;
	
	@FindBy(xpath = "//*[@class='pf-c-alert__icon']")
	public WebElement registrationPageRegistrationError;
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
}
