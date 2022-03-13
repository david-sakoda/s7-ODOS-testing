package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dataFactory.DataFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactories.DossierPage;
import pageFactories.HomePage;
import pageFactories.SignInPage;

public class DossierSteps {

	
		//Grabbing the WebDriver into local driver variable
		WebDriver driver = Hooks.WebDriver;
			
		//Initiating the WebDriverWait in wait variable
		WebDriverWait wait = Hooks.WebDriverWait(driver);
			
		//Initiating Home Page Elements in homePage variable
		HomePage homePage = new HomePage(driver);
		
		//Initiating Sign In Page Elements in signInPage variable
		SignInPage signInPage = new SignInPage(driver);
		
		//Initiating Dossier Page Elements in dossierPage variable
		DossierPage dossierPage = new DossierPage(driver);
		
		
		
		@And("system should display fifteen random dossiers")
		public void system_should_display_fifteen_random_dossiers() {
			
			wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
			
			List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
			
			Integer actualTotalDossierCount = dossiers.size();
			
			assertEquals(DataFactory.totalExpectedDossierCount, actualTotalDossierCount);
			
		}

		@Then("system should display movie information for each dossier")
		public void system_should_display_movie_information_for_each_dossier() {
			
			List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
			
			Integer actualTotalDossierCount = dossiers.size();
			
			for (int i = 0; i < actualTotalDossierCount; i++)
			
			{
				
				int dossierIndex = i + 1;
				String dossierMovieImageFinderText = homePage.homePageIndividualDossierLocatorText + "[" + dossierIndex + "]/img";
				String dossierMovieTitleFinderText = homePage.homePageIndividualDossierLocatorText + "[" + dossierIndex + "]/div/div";
				String dossierMoviePlotFinderText = homePage.homePageIndividualDossierLocatorText + "[" + dossierIndex + "]/div/p";
				String dossierViewDossierButtonFinderText = homePage.homePageIndividualDossierLocatorText + "[" + dossierIndex + "]/div/div/button[1]";
				
				boolean dossierMovieImageIsVisible = driver.findElement(By.xpath(dossierMovieImageFinderText)).isDisplayed();
				boolean dossierMovieTitleIsVisible = driver.findElement(By.xpath(dossierMovieTitleFinderText)).isDisplayed();
				boolean dossierMoviePlotIsVisible = driver.findElement(By.xpath(dossierMoviePlotFinderText)).isDisplayed();
				boolean dossierViewDossierButtonIsVisible= driver.findElement(By.xpath(dossierViewDossierButtonFinderText)).isDisplayed();
				
				assertEquals(dossierMovieImageIsVisible, true);
				assertEquals(dossierMovieTitleIsVisible, true);
				assertEquals(dossierMoviePlotIsVisible, true);
				assertEquals(dossierViewDossierButtonIsVisible, true);
				
			}
			
			
			
		}
		

		@Then("user clicks on view dossier button and user is navigated to the belonging dossier for each dossier displayed on the page")
		public void user_clicks_on_view_dossier_button_and_user_is_navigated_to_the_belonging_dossier_for_each_dossier_displayed_on_the_page() {
			
			
			wait.until(ExpectedConditions.visibilityOf(homePage.homePageDossier));
			
			List<WebElement> dossiers = driver.findElements(homePage.homePageDossiersLocator);
			
			Integer actualTotalDossierCount = dossiers.size();
			
			for (int i = 0; i < actualTotalDossierCount; i++) {
				
				int dossierIndex = i + 1;
				String dossierViewDossierButtonFinderText = homePage.homePageViewDossierButtonLocatorText + dossierIndex + "]";
				String dossierMovieTitleFinderText = "(" + homePage.homePageDossiersLocatorText + ")[" + dossierIndex + "]/div/div";
				
				String movieTitleFromHomePageDossier = driver.findElement(By.xpath(dossierMovieTitleFinderText)).getText();
				
				driver.findElement(By.xpath(dossierViewDossierButtonFinderText)).click();
				
				wait.until(ExpectedConditions.visibilityOf(dossierPage.dossierPageMovieImage));
				
				boolean imageFromDossierPageIsVisible = dossierPage.dossierPageMovieImage.isDisplayed();
				boolean movieTitleFromDossierPageIsVisible = dossierPage.dossierPageMovieTitle.isDisplayed();
				boolean moviePlotFromDossierPageIsVisible = dossierPage.dossierPageMoviePlot.isDisplayed();
				boolean viewReportButtonFromDossierPageIsVisible = dossierPage.dossierPageViewReportButton.isDisplayed();
				
				String movieTitleFromDossierPage = dossierPage.dossierPageMovieTitle.getText();		
				Boolean isDetailDisplayed = null;
				
				for(int x = 1; x <= 4 ; x++) {
					
					String movieDetail1 = driver.findElement(By.xpath(dossierPage.dossierPageMovieDetailsContainer + x + "]//td[1]")).getText();
					String movieDetail2 = driver.findElement(By.xpath(dossierPage.dossierPageMovieDetailsContainer + x + "]//td[2]")).getText();
					
					if (movieDetail1.length() > 0 && movieDetail2.length() > 0 ) {
						isDetailDisplayed = true;
					}
					else {
						
						isDetailDisplayed = false;
					}
					
					assertEquals(isDetailDisplayed, true);
					
				}
				
				assertEquals(imageFromDossierPageIsVisible, true);
				assertEquals(movieTitleFromDossierPageIsVisible, true);
				assertEquals(moviePlotFromDossierPageIsVisible, true);
				assertEquals(viewReportButtonFromDossierPageIsVisible, true);
				
				assertEquals(movieTitleFromHomePageDossier, movieTitleFromDossierPage);
				
				homePage.homePageHeader.click();
				
				
			}
		}
		
		@When("user clicks on one of the movie dossiers")
		public void user_clicks_on_one_of_the_movie_dossiers() {
			
			wait.until(ExpectedConditions.visibilityOf(homePage.homePageFirstMovieViewDossierButton));
			homePage.homePageFirstMovieViewDossierButton.click();
			wait.until(ExpectedConditions.visibilityOf(dossierPage.dossierPageMovieTitle));
		}
		
}
