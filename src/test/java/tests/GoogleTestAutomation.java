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
import org.testng.annotations.DataProvider;
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
	
	@DataProvider(name = "test1")
	public Object[][] createData1() throws IOException{
		ReadExcel read = new ReadExcel();
		Object[][] data = read.readExcelData("./src/test/resources/TestData.xlsx", "TestData");
		
		return data;
	}
	
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
	
	@Test(dataProvider = "test1")
	public void testCase1(String keyword) {
		Assert.assertEquals(driver.getTitle(), "Google");
//		driver.findElement(By.name("q")).sendKeys("testing");
//		
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		GoogleSearch searchPage = new GoogleSearch(driver);
		
		ReadExcel re = new ReadExcel();
		
//		Object[][] data = re.readExcelData("./src/test/resources/TestData.xlsx","TestData");
		searchPage.EnterKeyword(keyword);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
