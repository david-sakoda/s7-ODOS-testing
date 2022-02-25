package stepDefinitions;


import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.HomePage;
import pageFactories.RegistrationPage;
import pageFactories.SignInPage;

public class RegistrationSteps {
	
	//Grabbing the WebDriver into local driver variable
	WebDriver driver = Hooks.WebDriver;
		
	//Initiating the WebDriverWait in wait variable
	WebDriverWait wait = Hooks.WebDriverWait(driver);
		
	//Initiating Home Page Elements in homePage variable
	HomePage homePage = new HomePage(driver);
	
	//Initiating Sign In Page Elements in signInPage variable
	SignInPage signInPage = new SignInPage(driver);
	
	//Initiating Registration Page Elements in registrationPage variable
	RegistrationPage registrationPage = new RegistrationPage(driver);
	

	@When("user clicks on register button")
	public void user_clicks_on_register_button() {
		
		signInPage.registerLink.click();

	}

	@Then("user is navigated to the registration page")
	public void user_is_navigated_to_the_registration_page() {
		
		wait.until(ExpectedConditions.visibilityOf(registrationPage.registrationPageRegisterButton));
	}
	
	@When("^user enters (.*) , (.*) , (.*) , (.*) , (.*)$")
	public void user_enters_firstname_lastname_email_password_groupmembership(String firstName, String lastName, String email, String password, String groupMembership) {
				 
		
		if(email.equals("random")) {
			
			Random random = new Random();
			int randomInteger = random.nextInt(100000, 999999);
			
			email = "testemail" + randomInteger + "@selenium.com";
			
		}
		
		registrationPage.registrationPageFirstNameInput.sendKeys(firstName);
		registrationPage.registrationPageLastNameInput.sendKeys(lastName);
		registrationPage.registrationPageEmailInput.sendKeys(email);
		registrationPage.registrationPagePasswordInput.sendKeys(password);
		registrationPage.registrationPageConfirmPasswordInput.sendKeys(password);
		
		Select groupDropdown = new Select(registrationPage.registrationPageGroupDropdown);
		
		groupDropdown.selectByValue(groupMembership);
		
	}

	@When("user clicks on register button from registration page")
	public void user_clicks_on_register_button_from_registration_page() {
		
		registrationPage.registrationPageRegisterButton.click();
		
	}

	@Then("^(.*) and (.*) are displayed on the header of the application$")
	public void user_name_is_displayed_on_the_header_of_the_application(String firstName, String lastName) {
		
		String expectedUserName = firstName + " " + lastName;
		String actualUserName = homePage.homePageUserName.getText();
		
		assertEquals(expectedUserName, actualUserName);
		
		
	}

	@Then("^(.*) is displayed on header user information dropdown$")
	public void user_role_is_displayed_on_header_user_information_dropdown(String groupMembership) {

		homePage.homePageUserIcon.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homePageUserRole));
		
		String expectedUserRole;
		
		System.out.println(groupMembership);
		
		if(groupMembership.equals("Users")) {
			
			expectedUserRole = "USER";
		}
		
		else if(groupMembership.equals("Supervisors")) {
			
			expectedUserRole = "SUPERVISOR";
		}
		else {
			expectedUserRole = null;
		}
		
		String actualGroupMembership = homePage.homePageUserRole.getText();
		
		actualGroupMembership = actualGroupMembership.substring(6);
		
		assertEquals(expectedUserRole, actualGroupMembership);
		
	}

	@Then("system should display the belonging error for the invalid registration information")
	public void system_should_display_the_belonging_error_for_the_invalid_registration_information() {
		
		String actualError = registrationPage.registrationPageRegistrationError.getText();
		
		String expectedFirstNameError = "Please specify first name.";
		String expectedLastNameError = "Please specify last name.";
		String expectedEmailError = "Please specify email.";
		String expectedPasswordError = "Please specify password.";
		
		assertEquals(true, actualError.contains(expectedFirstNameError));
		assertEquals(true, actualError.contains(expectedLastNameError));
		assertEquals(true, actualError.contains(expectedEmailError));
		assertEquals(true, actualError.contains(expectedPasswordError));
	}

	@Then("system should display invalid email address error")
	public void system_should_display_invalid_email_address_error() {
		
		String actualError = registrationPage.registrationPageRegistrationError.getText(); 
		String expectedEmailError = "Invalid email address.";
		
		assertEquals(true, actualError.contains(expectedEmailError));
	}

	@Then("system should display password does not match error")
	public void system_should_display_password_does_not_match_error() {
		
		String actualError = registrationPage.registrationPageRegistrationError.getText(); 
		String expectedPasswordError = "Password confirmation doesn't match.";
		
		assertEquals(true, actualError.contains(expectedPasswordError));
	}
	
	@When("user enters an invalid email to the email inputbox")
	public void user_enters_an_invalid_email_to_the_email_inputbox() {
		
		registrationPage.registrationPageEmailInput.sendKeys("12345");
	}

	@When("user enters a non matching password for the password inputboxes")
	public void user_enters_a_non_matching_password_for_the_password_inputboxes() {
		
		registrationPage.registrationPagePasswordInput.sendKeys("12345");
		registrationPage.registrationPageConfirmPasswordInput.sendKeys("123456");
	}
	
}
