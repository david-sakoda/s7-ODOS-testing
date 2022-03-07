package dataFactory;

public class DataFactory {

	public static String projectPath = System.getProperty("user.dir");
	public static String chromeDriverPath = projectPath + "/src/test/resources/BrowserDrivers/chromedriver.exe";
	public static String geckoDriverPath = projectPath + "/src/test/resources/BrowserDrivers/geckodriver.exe";
	public static String projectUrl = "http://dev-ui.sierra7odos.com/";
	
	//Expected results
	
	public static String homePageExpectedHeaderText = "RetroPaper Movie Spider";
	public static String signInExpectedErrorText = "Invalid username or password.";
	public static Integer totalExpectedDossierCount = 5;

};
