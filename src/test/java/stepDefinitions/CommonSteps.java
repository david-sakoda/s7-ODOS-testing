package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataFactory.DataFactory;
import io.cucumber.java.en.*;
import pageFactories.HomePage;
import pageFactories.SignInPage;


public class CommonSteps {
	
	//Grabbing the WebDriver into local driver variable
	WebDriver driver = Hooks.WebDriver;
	
	//Initiating the WebDriverWait in wait variable
	WebDriverWait wait = Hooks.WebDriverWait(driver);
	
	//Initiating Home Page Elements in homePage variable
	HomePage homePage = new HomePage(driver);
	
	//Initiating Home Page Elements in homePage variable
	SignInPage signInPage = new SignInPage(driver);
	
	
	@When("user enters the url")
	public void user_enters_the_url() {
		
		//Navigating to the Project Home Page
		driver.get(DataFactory.projectUrl);
		
	}
	
	@Then("user is navigated to the login page")
	public void user_is_navigated_to_the_login_page() {

		wait.until(ExpectedConditions.visibilityOf(signInPage.signInPageUSCISLogo));

	}

	@Then("user is navigated to the home page")
	public void user_navigated_to_the_home_page() {
		
		
		wait.until(ExpectedConditions.visibilityOf(homePage.homePageHeader));
		
		String actualHeaderText = homePage.homePageHeader.getText();

		assertEquals(DataFactory.homePageExpectedHeaderText, actualHeaderText);
	
	}

}
