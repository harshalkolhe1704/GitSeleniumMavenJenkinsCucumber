package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {
	
	WebDriver driver;
	public GoogleSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBox = By.name("q");
	
	
	public void EnterKeyword(String keyword) {
		driver.findElement(searchBox).sendKeys(keyword);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
}
