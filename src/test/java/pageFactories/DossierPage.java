package pageFactories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DossierPage {
	
	@FindBy(xpath = "//*[@id='cover']/img")
	public WebElement dossierPageMovieImage;
	
	@FindBy(xpath = "//div/div/main/div/div/h2")
	public WebElement dossierPageMovieTitle;
	
	@FindBy(xpath = "//*[@id='description']/p[1]")
	public WebElement dossierPageMoviePlot;
	
	@FindBy(xpath = "//*[contains(text(),'VIEW REPORT')]")
	public WebElement dossierPageViewReportButton;
	
	public String dossierPageMovieDetailsContainer = "//*[contains(@class,'MuiTableRow-root')][";
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableRow-root')][2]//td[2]")
	public WebElement dossierPageMovieStarringInfo;
	
	
//	@FindBy(xpath = "//*[contains (@class, 'MuiButton-outlined')]")
//	public WebElement dossierPageBackButton;
		
	
	
	
	WebDriver driver;
	
	public DossierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
}
