package canalConsulta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import tela.Login;

public class CanalPagesConsulta {
	
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	
	public CanalPagesConsulta(WebDriver driver){
		this.driver = driver;
	}
	
public static Properties getProp() throws Exception{
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/login.properties");
		props.load(file);
		
		return props;
	}
	
	
	public void visita(){
		
		try {
			Properties prop = getProp();
			if (System.getProperty(SIGMS_URL) == null)
				baseUrl = prop.getProperty("prop.url.local");
			//baseUrl = "https://sigms-novo.des.coresp.caixa/sigms/";
			else
				baseUrl = System.getProperty(SIGMS_URL);
			
			if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
				System.setProperty(WEBDRIVER_CHROME_DRIVER, prop.getProperty("prop.driverCrhome"));
			
			driver = new ChromeDriver();
			driver.get(baseUrl);
			
			driver.findElement(By.id("login-username")).sendKeys(prop.getProperty("prop.usuario"));
			driver.findElement(By.id("login-password")).sendKeys(prop.getProperty("prop.senha"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
  public NovoCanalPageConsulta novo(){
		
		driver.findElement(By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div/div[2]/input")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
		
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[3]/a")).click();
		                             
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[3]/ul/li[2]/a")).click();	
		
		return new NovoCanalPageConsulta(driver);
	}
  
  
	public void ResultadoConsulta(int codigo, String sigla, boolean habilitado, String descricao){
		
		WebElement inputCodigo = driver.findElement(By.name("codigo"));
		inputCodigo.getAttribute(String.valueOf(codigo));
		
		WebElement inputSigla = driver.findElement(By.name("sigla"));
		inputSigla.getAttribute(sigla);
		
		WebElement ckHabilitado = driver.findElement(By.id("chkSituacao"));
		ckHabilitado.getAttribute(String.valueOf(habilitado));
		
		WebElement inputDescricao = driver.findElement(By.name("descricao"));
		inputDescricao.getAttribute(descricao);
		
		}
	
	
	public WebDriver getDriver() {
		return driver;
	}

}
