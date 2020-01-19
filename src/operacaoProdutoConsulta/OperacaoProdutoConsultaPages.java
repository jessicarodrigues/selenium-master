package operacaoProdutoConsulta;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OperacaoProdutoConsultaPages {
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	public OperacaoProdutoConsultaPages(WebDriver driver){
		this.driver = driver;
	}
	
	public void visita(String login, String senha, String driverChrome){
		
		if (System.getProperty(SIGMS_URL) == null)
			baseUrl = "http:localhost:8080/sigms"; 
		else
			baseUrl = System.getProperty(SIGMS_URL);
		
		if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
			System.setProperty(WEBDRIVER_CHROME_DRIVER, driverChrome);

		driver = new ChromeDriver();
		driver.get(baseUrl);
		
		driver.findElement(By.id("login-username")).sendKeys(login);
		driver.findElement(By.id("login-password")).sendKeys(senha);
	}
	
	public NovoOPConsultaPage novo(){
		
		driver.findElement(By.xpath("//*[@id=\"loginbox\"]/div/div[2]/form/div/div[2]/input")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
        
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[4]/ul/li[2]/a")).click();
		
		return new NovoOPConsultaPage(driver);
											
	}
	
  public void resultadoConsultaOP(int codigo, String tipoConta, String tipoDocumento, String servicos, String servicosAssociados){
			
		WebElement inputCodigo = driver.findElement(By.name("produtoVO.codigo"));
		inputCodigo.getAttribute(String.valueOf(codigo));
		
		Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
		cbTipoConta.selectByVisibleText(tipoConta);
		
		Select cbTipoDocumento = new Select(driver.findElement(By.name("produtoVO.tipoPessoa")));
		cbTipoDocumento.selectByVisibleText(tipoDocumento);
		
		Select cbServico = new Select(driver.findElement(By.name("servicos")));
		cbServico.selectByVisibleText(servicos);
		
		Select cbServicosAssociados = new Select(driver.findElement(By.name("servicosAssociadosSelecionado")));
		cbServicosAssociados.selectByVisibleText(servicosAssociados);
	}
}
