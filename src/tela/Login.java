package tela;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	WebDriver driver;
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
public void abreBrowser(){
		
		
		//driver.manage().window().maximize();
		//driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		
		 String driverChrome = "C:\\chromedriver\\chromedriver.exe";
			if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
				System.setProperty(WEBDRIVER_CHROME_DRIVER, driverChrome);
			
			
			driver = new ChromeDriver();
			driver.get("http://localhost:8080/sigms/");    
	}

@Test
public void login(){
	
	try{		
		//LOCAL	
		
		//DES
//		driver.get("https://sigms-novo.des.coresp.caixa/sigms/");
		
		WebElement usuario = driver.findElement(By.name("username"));
		usuario.sendKeys("C899009");
		WebElement senha = driver.findElement(By.name("password"));
		senha.sendKeys("c899009");
		senha.submit();
	}
	catch(NoSuchElementException e){
		System.out.println("Link informado não encontrado.");
		driver.close();
	}
	
	//Resultado esperado
	boolean loginOk = driver.getPageSource().contains("Operador:");
	assertTrue(loginOk);
	//driver.quit();

}

public WebDriver getDriver() {
	return driver;
}



}
