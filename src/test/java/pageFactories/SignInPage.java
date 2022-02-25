package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	
	@FindBy(xpath = "//*[@alt='USCIS']")
	public WebElement signInPageUSCISLogo;
	
	@FindBy(xpath = "//*[@id='username']")
	public WebElement usernameInputBox;
	
	@FindBy(xpath = "//*[@id='password']")
	public WebElement passwordInputBox;
	
	@FindBy(xpath = "//*[@id='kc-login']")
	public WebElement signInButton;
	
	@FindBy(xpath = "//*[@id='input-error']")
	public WebElement invalidSignInError;
	
	@FindBy(xpath = "//*[@id='rememberMe']")
	public WebElement rememberMeCheckbox;
	
	@FindBy(xpath = "//*[@id='kc-registration']//a")
	public WebElement registerLink;
	
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
}
