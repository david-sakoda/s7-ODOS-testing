package stepDefinitions;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.WebDriver;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import config.PropertiesFile;
import io.cucumber.java.en.When;

public class ODOSAllyTests {
	
	//Grabbing the WebDriver into local driver variable
	WebDriver driver = Hooks.WebDriver;
			
	@When("^test accessibility for .*$")
	public void test_accessibility_for__page() {
		
		boolean allyStatus = true;
		
		if(PropertiesFile.Browser.equals("chrome")) {
			
			AxeBuilder axe = new AxeBuilder();
			
			List<Rule> results = axe.analyze(driver).getViolations();
			
			if(results.size() > 0) {
				
				allyStatus = false;
				
				for(int i = 0; i < results.size(); i++) {
					
					Hooks.scenario.log(results.get(i).toString());
				}
			}
			else {
				
				allyStatus = true;
			}
		}
		assertEquals(true, allyStatus);
	}
}
