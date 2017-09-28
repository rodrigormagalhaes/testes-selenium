package org.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchTest {
	
	public static void main (String[] args) {
		
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
		//WebDriver driver = new FirefoxDriver();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
				
		WebDriver driver = new ChromeDriver(options);
		
		driver.navigate().to("http://www.google.com");
		
		GoogleHomePageObjects page = new GoogleHomePageObjects(driver);
		
		page.txtSearch.sendKeys("Rodrigo Magalhães ");
		
		//page.btnSearch.click();
		
		page.txtSearch.sendKeys(Keys.ENTER);
		
		driver.close();
	}
	
}


