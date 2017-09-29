package org.pom;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pom.utils.IOManager;

public class GoogleSearchTest {

	static IOManager ioManager;
	static WebDriver driver;

	public static void main(String[] args) throws IOException {

		try {

			// Recebe o arquivo config.txt que é setado em Run Configurations >>
			// Arguments
			String fileInput = args[0];

			// Cria o controlador do arquivo
			ioManager = new IOManager(fileInput);

			// Pega a primeira linha >> url
			String line = ioManager.getLineInput();

			// System.setProperty("webdriver.firefox.bin", "C:\\Program Files
			// (x86)\\Mozilla Firefox\\firefox.exe");

			// WebDriver driver = new FirefoxDriver();

			// Iniciar Chrome driver maximizado
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

			driver = new ChromeDriver(options);

			long start = System.currentTimeMillis();
			
			// seta a url
			driver.navigate().to(line);			
			
			long finish = System.currentTimeMillis();
			
			long totalTime = finish - start;
			
			System.out.println("Total load time: " + totalTime);
			
			// Pega a próxima linha >> texto a ser buscado
			line = ioManager.getLineInput();

			// Cria a Page Objects
			GoogleHomePageObjects page = new GoogleHomePageObjects(driver);
			
			checkPageIsReady();

			// seta o valor a ser pesquisado no campo de pesquisa do google
			page.txtSearch.sendKeys(line);

			// page.btnSearch.click();

			// simula o enter
			page.txtSearch.sendKeys(Keys.ENTER);

			// Aguarda 5 segundos pra prosseguir
			Thread.sleep(5000);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// fecha conexões
			ioManager.close();
			driver.close();

		}
	}

	public static void checkPageIsReady() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
	

}
