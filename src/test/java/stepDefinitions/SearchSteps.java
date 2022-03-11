package stepDefinitions;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.DossierPage;
import pageFactories.HomePage;

public class SearchSteps {

	//Grabbing the WebDriver into local driver variable
	WebDriver driver = Hooks.WebDriver;
		
	//Initiating the WebDriverWait in wait variable
	WebDriverWait wait = Hooks.WebDriverWait(driver);
		
	//Initiating Home Page Elements in homePage variable
	HomePage homePage = new HomePage(driver);
	
	//Initiating Dossier Page Elements in dossierPage variable
	DossierPage dossierPage = new DossierPage(driver);

		
	@When("^user searches the (.*)$")
	public void user_searches_the_search_text(String searchText) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
		homePage.homePageSearchInputbox.sendKeys(searchText);
		wait.until(ExpectedConditions.invisibilityOf(homePage.homePageDossier));
		
	}

	@Then("^system should display movies matching (.*) with movie title or actor or movie character$")
	public void system_should_display_movies_matching_search_text_with_movie_title_or_actor_or_movie_character(String searchText) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
		
		List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
		
		Integer actualTotalDossierCount = dossiers.size();
		
		for (int i = 0; i < actualTotalDossierCount; i++) {
			
			int dossierIndex = i + 1;
			String dossierViewDossierButtonFinderText = homePage.homePageViewDossierButtonLocatorText + dossierIndex + "]";
			String dossierMovieTitleFinderText = homePage.homePageIndividualDossierLocatorText + "[" + dossierIndex + "]/div/div";
			
			String movieTitleFromHomePage = driver.findElement(By.xpath(dossierMovieTitleFinderText)).getText();
			
			driver.findElement(By.xpath(dossierViewDossierButtonFinderText)).click();
			
			wait.until(ExpectedConditions.visibilityOf(dossierPage.dossierPageMovieImage));
			
			String movieTitleFromDossierPage = dossierPage.dossierPageMovieTitle.getText();
			String actorNamesFromDossierPage = dossierPage.dossierPageMovieStarringInfo.getText();
			
			Hooks.scenario.log("Clicked on movie: " + movieTitleFromHomePage);
			Hooks.scenario.log("Dossier page movie title: " + movieTitleFromDossierPage);
			Hooks.scenario.log("Dossier page Actor Information: " + actorNamesFromDossierPage);
			
			boolean isTitleAMatch = movieTitleFromDossierPage.contains(searchText);
			boolean isActorOrCharacterAMatch = actorNamesFromDossierPage.contains(searchText);
			boolean isMovieAMatch;
			
			if(isTitleAMatch == true || isActorOrCharacterAMatch == true) {
				
				isMovieAMatch = true;
				
			}
			else {
				
				isMovieAMatch = false;
			}
			
			assertEquals(true, isMovieAMatch);
			
			homePage.homePageHeader.click();
			homePage.homePageSearchInputbox.sendKeys(searchText);
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
	    }
	}
}
