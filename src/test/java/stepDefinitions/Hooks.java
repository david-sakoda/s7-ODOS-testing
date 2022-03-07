package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.PropertiesFile;
import dataFactory.DataFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver WebDriver;
	public static Scenario scenario;

	@Before
	public void WebDriver() {
		
		PropertiesFile.getBrowserSelection();
		
		if(PropertiesFile.Browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", DataFactory.chromeDriverPath);
			WebDriver = new ChromeDriver();
			System.out.println("Browser is set to Chrome");
			
		}
		
		if(PropertiesFile.Browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", DataFactory.geckoDriverPath);
			WebDriver = new FirefoxDriver();
			System.out.println("Browser is set to Firefox");
			
		}
		
		WebDriver.manage().window().maximize();
	}
	
	@Before
	public void Scenario(Scenario scenario) {
		
		Hooks.scenario = scenario;
	}
	
	public static WebDriverWait WebDriverWait(WebDriver driver) {
		
		PropertiesFile.getWaitTimeout();
		
		int timeOut = Integer.parseInt(PropertiesFile.WaitTimeout);
		
		WebDriverWait wait = new WebDriverWait(Hooks.WebDriver, Duration.ofSeconds(timeOut));
		return wait;
	}
	
	@BeforeStep
	public void BeforeStepScreenshot() {
		
		TakesScreenshot scrShot =((TakesScreenshot)WebDriver);
		
		byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);
	
		Hooks.scenario.attach(SrcFile, "image/png", "Screenshot");
		
	}
	
	@AfterStep
	public void AfterStepScreenshot() {
		
		TakesScreenshot scrShot =((TakesScreenshot)WebDriver);
		
		byte[] SrcFile = scrShot.getScreenshotAs(OutputType.BYTES);
		
		Hooks.scenario.attach(SrcFile, "image/png", "Screenshot");
		
	}
	
	
	@After
	public void TearDown() {
		
		WebDriver.quit();
	}
}
