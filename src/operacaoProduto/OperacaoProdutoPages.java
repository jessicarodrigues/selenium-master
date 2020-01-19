package operacaoProduto;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OperacaoProdutoPages {

	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	public OperacaoProdutoPages(WebDriver driver){
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
			else
				baseUrl = System.getProperty(SIGMS_URL);
			
			if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
				System.setProperty(WEBDRIVER_CHROME_DRIVER, prop.getProperty("prop.driverCrhome"));
			
			driver = new ChromeDriver();
			driver.get(baseUrl);
			
			driver.findElement(By.id("login-username")).sendKeys(prop.getProperty("prop.usuario"));
			driver.findElement(By.id("login-password")).sendKeys(prop.getProperty("prop.senha"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public NovoInclusaoOperacaoPage novo(){

		driver.findElement(By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div/div[2]/input")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
        
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[4]/a")).click();
		                             
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[4]/ul/li[1]/a")).click();
		
		return new  NovoInclusaoOperacaoPage(driver);
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
