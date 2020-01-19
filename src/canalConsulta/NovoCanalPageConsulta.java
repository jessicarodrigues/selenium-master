package canalConsulta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoCanalPageConsulta {
	
	private final WebDriver driver;

	public NovoCanalPageConsulta(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ConsultaCanal(String canal){
		
		try{
		Select cbCanal = new Select(driver.findElement(By.name("codigo")));
		cbCanal.selectByVisibleText(canal);
		Thread.sleep(2000L);
		
		WebElement buttonConsultar = driver.findElement(By.id("btnConsultarCanal"));
		buttonConsultar.click();
		Thread.sleep(2000L);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
