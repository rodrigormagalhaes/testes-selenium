package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroAmericanasPageObject {
	
	public CadastroAmericanasPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="cep")
	public WebElement inputCep;

	@FindBy(name="email")
	public WebElement inputEmail;
	
	@FindBy(css="#a-header > div.a-top-header > ul > li:nth-child(3) > a")
	public WebElement linkMeusPedidos;
	
	@FindBy(css="#a-header > div.a-top-header")
	public WebElement topo;
	
	
	
	
	
}


