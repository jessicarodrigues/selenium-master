package canalAltera;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoCanalPageAltera {
	
	private final WebDriver driver;

	public NovoCanalPageAltera(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Altera(String canal){
		
		try{
		Select cbCanal = new Select(driver.findElement(By.name("codigo")));
		cbCanal.selectByVisibleText(canal);
		Thread.sleep(2000L);
		
		WebElement buttonAltera = driver.findElement(By.id("btnAlterarCanal"));
		buttonAltera.click();
		Thread.sleep(2000L);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	}
}
