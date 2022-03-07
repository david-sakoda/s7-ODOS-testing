package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	public static String Browser;
	public static String WaitTimeout;

	public static void getBrowserSelection() {
		
		Properties prop = new Properties();
		InputStream input;
		
		try {
			
			input = new FileInputStream(dataFactory.DataFactory.projectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			Browser = prop.getProperty("browser");
			input.close();
			
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			
		}
	}
	
	public static void getWaitTimeout() {
		
		Properties prop = new Properties();
		InputStream input;
		
		
		try {
			
			input = new FileInputStream(dataFactory.DataFactory.projectPath + "/src/test/java/config/config.properties");
			prop.load(input);
			WaitTimeout = prop.getProperty("waittimeout");
			input.close();
			
		} catch (Exception ex) {
			
			System.out.println(ex.getMessage());
			System.out.println(ex.getCause());
			
		}
	}
}
