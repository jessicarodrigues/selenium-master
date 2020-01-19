package canalExclusao;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanalPagesDelete {
	
	private WebDriver driver;
	private String baseUrl;
	
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	public CanalPagesDelete(WebDriver driver){
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
	
	public NovoCanalPageDelete novo(){
		driver.findElement(By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div/div[2]/input")).click();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[3]/a")).click();                          
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[3]/ul/li[2]/a")).click();
		return new NovoCanalPageDelete(driver);
	}
	
	public void resultadoExclusao(int codigo, String sigla, boolean habilitado, String descricao){
		
		try{
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement inputCodigo = driver.findElement(By.name("codigo"));
		inputCodigo.getAttribute(String.valueOf(codigo));
		Thread.sleep(2000L);
		WebElement inputSigla = driver.findElement(By.name("sigla"));
		inputSigla.getAttribute(sigla);
		Thread.sleep(2000L);
		WebElement ckHabilitado = driver.findElement(By.id("chkSituacao"));
		ckHabilitado.getAttribute(String.valueOf(habilitado));
		Thread.sleep(2000L);
		WebElement inputDescricao = driver.findElement(By.name("descricao"));
		inputDescricao.getAttribute(descricao);
		Thread.sleep(2000L);
		WebElement buttonConfirmaExclusao = driver.findElement(By.id("btn-excluir"));
		buttonConfirmaExclusao.click();
		Thread.sleep(2000L);
		js.executeScript("document.getElementById('modalConfirmarAcao').click();");
		Thread.sleep(3000L);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
