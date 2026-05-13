package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driverSetup.BrowserSetup;
import pages.GoogleSearch;
import utils.ReadExcel;
import utils.ReadProperties;

public class GoogleTestAutomation {
	WebDriver driver;
	ReadProperties rp;
	BrowserSetup bs = new BrowserSetup();
	@BeforeMethod
	@Parameters("Browser")
	public void setup(@Optional ("chrome") String browser) throws IOException{
	
		driver = bs.setupBrowser(browser);
		
		rp  = new ReadProperties();
		
		driver.get(rp.ReadProperty("./src/test/resources/config.properties", "url"));
	}
	
//	public void setup() throws IOException {
//		BrowserSetup bs = new BrowserSetup();
//		driver = bs.setupBrowser("chrome");
//	
//		rp  = new ReadProperties();
//		
//		driver.get(rp.ReadProperty("./src/test/resources/config.properties", "url"));
//		
////		if(rp.ReadProperty("/GitSeleniumMavenJenkinsCucumber/src/main/resources/config.properties", "browser").equalsIgnoreCase("Chrome")) {
////			driver = new ChromeDriver();
////		}
////		else if(rp.ReadProperty("/GitSeleniumMavenJenkinsCucumber/src/main/resources/config.properties", "browser").equalsIgnoreCase("edge")){
////			driver = new EdgeDriver();
////		}
////		else {
////			System.out.println("Invalid browser");
////		}
//	}
	
	@Test
	public void testCase1() throws IOException {
		Assert.assertEquals(driver.getTitle(), "Google");
//		driver.findElement(By.name("q")).sendKeys("testing");
//		
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		GoogleSearch searchPage = new GoogleSearch(driver);
		
		ReadExcel re = new ReadExcel();
		
		Object[][] data = re.readExcelData("./src/test/resources/TestData.xlsx","TestData");
		searchPage.EnterKeyword(data[0][0].toString());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
