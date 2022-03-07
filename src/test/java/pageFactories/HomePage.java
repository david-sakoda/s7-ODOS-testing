package pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(xpath = "//*[contains(@class, 'MuiTypography-noWrap')]")
	public WebElement homePageHeader;
	
	@FindBy(xpath = "//*[contains (@class, 'MuiPaper-elevation1 MuiCard-root')]")
	public WebElement homePageDossier;
	
	@FindBy(xpath = "//*[contains (@class, 'MuiIconButton-root')]")
	public WebElement homePageUserIcon;
	
	@FindBy(xpath = "//*[contains (@class, 'MuiIconButton-root')]/p")
	public WebElement homePageUserName;
	
	@FindBy(xpath = "//*[@id=\"menu-appbar\"]/div[3]/ul/ul/p")
	public WebElement homePageUserRole;
	
	@FindBy(xpath = "//*[@id='menu-appbar']/div[3]/ul/ul/li")
	public WebElement homePageLogoutButton;
	
	@FindBy(xpath = "//*[@id='search-field']")
	public WebElement homePageSearchInputbox;
	
	@FindBy(xpath = "//*[contains (@class, 'MuiPaper-elevation1 MuiCard-root')][1]/div/div/button")
	public WebElement homePageFirstMovieViewDossierButton;
	
	
	
	public By homePageDossiersLocator = By.xpath("//*[contains (@class, 'MuiPaper-elevation1 MuiCard-root')]");
	
	public String homePageDossiersLocatorText = "//*[contains (@class, 'MuiPaper-elevation1 MuiCard-root')]";
	
	
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
				
	}
}
 