package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dataFactory.DataFactory;
import dataFactory.Encryption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.HomePage;
import pageFactories.SignInPage;

public class LoginSteps {
	
	//Grabbing the WebDriver into local driver variable
	WebDriver driver = Hooks.WebDriver;
		
	//Initiating the WebDriverWait in wait variable
	WebDriverWait wait = Hooks.WebDriverWait(driver);
		
	//Initiating Home Page Elements in homePage variable
	HomePage homePage = new HomePage(driver);
	
	//Initiating Sign In Page Elements in signInPage variable
	SignInPage signInPage = new SignInPage(driver);


	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
		signInPage.usernameInputBox.sendKeys(Encryption.Decoder(username));
		signInPage.passwordInputBox.sendKeys(Encryption.Decoder(password));
	}

	@When("user clicks on sign in button from sign in page")
	public void user_clicks_on_sign_in_button_from_sign_in_page() {
		
		signInPage.signInButton.click();
	}
	
	@Then("system should display invalid username or password error")
	public void system_should_display_invalid_username_or_password_error() {
		
		wait.until(ExpectedConditions.visibilityOf(signInPage.invalidSignInError));
	
		String actualErrorText = signInPage.invalidSignInError.getText();

		assertEquals(DataFactory.signInExpectedErrorText, actualErrorText);
	}
	
	
}
