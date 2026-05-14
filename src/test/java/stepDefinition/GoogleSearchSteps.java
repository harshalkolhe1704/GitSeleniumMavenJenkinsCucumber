package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverSetup.BrowserSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GoogleSearch;
import utils.ReadProperties;

public class GoogleSearchSteps {
	
	WebDriver driver;
	ReadProperties rp = new ReadProperties();
	
	@Given("I am on the search page")
	public void i_am_on_the_search_page() throws IOException {
		BrowserSetup bs = new BrowserSetup();
		driver = bs.setupBrowser("Chrome");
		driver.get(rp.ReadProperty("./src/test/resources/config.properties", "url"));
	}

	@When("I search for a keyword")
	public void i_search_for_a_keyword() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
	    
	    GoogleSearch searchPage = new GoogleSearch(driver);
	    searchPage.EnterKeyword("Testing");
	}

	@Then("I should see search results for keyword")
	public void i_should_see_search_results_for_keyword() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		Assert.assertEquals(driver.getTitle(), "Google");
		System.out.println("Step Execution Completed...");
		
	}

}
