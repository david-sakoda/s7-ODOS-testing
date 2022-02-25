package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.HomePage;
import pageFactories.SignInPage;

public class LogoutSteps {
	
		//Grabbing the WebDriver into local driver variable
		WebDriver driver = Hooks.WebDriver;
			
		//Initiating the WebDriverWait in wait variable
		WebDriverWait wait = Hooks.WebDriverWait(driver);
			
		//Initiating Home Page Elements in homePage variable
		HomePage homePage = new HomePage(driver);
		
		//Initiating Sign In Page Elements in signInPage variable
		SignInPage signInPage = new SignInPage(driver);

		@When("user clicks user logo from home page")
		public void user_clicks_user_logo_from_home_page() {
				
			wait.until(ExpectedConditions.elementToBeClickable(homePage.homePageUserIcon));
			
			homePage.homePageUserIcon.click();
			
		}

		@Then("logout button should display")
		public void logout_button_should_display() {
			
			wait.until(ExpectedConditions.elementToBeClickable(homePage.homePageLogoutButton));
			
			Boolean isLogoutButtonVisible = homePage.homePageLogoutButton.isDisplayed();
			
			assertEquals(isLogoutButtonVisible, true);

		}

		@When("user clicks logout button")
		public void user_clicks_logout_button() {
			
			homePage.homePageLogoutButton.click();
			
		}

}
