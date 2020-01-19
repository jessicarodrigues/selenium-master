package canal;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NovoCanalPage {
	
	private final WebDriver driver;
	
	public NovoCanalPage(WebDriver driver){
		this.driver = driver;
	}

	public void cadastra(int codigo, String sigla, boolean habilitado, String descricao){
		
		try{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement inputCodigo = driver.findElement(By.name("codigo"));
		inputCodigo.sendKeys(String.valueOf(codigo));
		Thread.sleep(2000L);
		
		WebElement inputSigla = driver.findElement(By.name("sigla"));
		inputSigla.sendKeys(sigla);
		Thread.sleep(2000L);
		
		WebElement ckHabilitado = driver.findElement(By.id("chkSituacao"));
		ckHabilitado.click();
		Thread.sleep(2000L);
		
		WebElement inputDescricao = driver.findElement(By.name("descricao"));
		inputDescricao.sendKeys(descricao);
		Thread.sleep(2000L);
		
		WebElement buttonIncluir = driver.findElement(By.id("btn-incluir"));
		buttonIncluir.click();
		Thread.sleep(2000L);
		
		js.executeScript("document.getElementById('modalConfirmarAcao').click();");
		Thread.sleep(2000L);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
