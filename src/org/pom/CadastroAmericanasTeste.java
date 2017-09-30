package org.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CadastroAmericanasTeste {

	static WebDriver driver; 
	
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
				
		driver = new ChromeDriver(options);

		driver.navigate().to("https://cliente.americanas.com.br/s/cadastro/pf/?guest=false");
		
		CadastroAmericanasPageObject cadastro = new CadastroAmericanasPageObject(driver);

		cadastro.inputCep.sendKeys("38408220");
		
		//cadastro.topo.click();
		
		//cadastro.inputCep.sendKeys(Keys.HOME);
		
		
		//cadastro.inputCep.sendKeys(Keys.TAB);
		
		//cadastro.inputEmail.sendKeys("rodrigo@teste.com");
		
		//cadastro.linkMeusPedidos.click();
		
		Actions builder = new Actions(driver);   
		builder.moveToElement(cadastro.topo, 10, 25).click().build().perform();
		
	}

}
