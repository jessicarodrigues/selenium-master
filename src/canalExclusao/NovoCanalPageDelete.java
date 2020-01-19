package canalExclusao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoCanalPageDelete {
	
	private final WebDriver driver;
	
	public NovoCanalPageDelete(WebDriver driver){
		this.driver = driver;
	}
	
	public void exclui(String canal){
		
		try{
		Select cbCanal = new  Select(driver.findElement(By.name("codigo")));
		cbCanal.selectByVisibleText(canal);
		Thread.sleep(2000L);
		
		WebElement buttonExcluiCanal = driver.findElement(By.id("btnExcluirCanal"));
		buttonExcluiCanal.click();
		Thread.sleep(2000L);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
