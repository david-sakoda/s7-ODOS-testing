package stepDefinitions;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.HomePage;

public class InfiniteScrollSteps {

	
		//Grabbing the WebDriver into local driver variable
		WebDriver driver = Hooks.WebDriver;
			
		//Initiating the WebDriverWait in wait variable
		WebDriverWait wait = Hooks.WebDriverWait(driver);
		
		//Initiating actions
		Actions actions = new Actions(driver);
		
		//Initiating Home Page Elements in homePage variable
		HomePage homePage = new HomePage(driver);
		
		Integer totalDossierCount;
		
		@When("user scrolls down to the very bottom dossier")
		public void user_scrolls_down_to_the_very_bottom_dossier() {
			
			wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
			
			List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
			
			totalDossierCount = dossiers.size();
			
			actions.moveToElement(dossiers.get(totalDossierCount-1));
			actions.perform();
			
		}
		
		@Then("system should load fifteen more dossiers")
		public void system_should_load_fifteen_more_dossiers() {
			
			List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
			
			Integer newTotalDossierCount = dossiers.size();
			Integer expectedTotalDossierCount = (totalDossierCount + 15);
			
			assertEquals(expectedTotalDossierCount, newTotalDossierCount);
			
			
		}
}

