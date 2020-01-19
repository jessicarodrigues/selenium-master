package adesao;
import static org.junit.Assert.assertTrue;
import java.io.FileInputStream;
import java.util.Properties;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Adesao {
	AdesaoVO adesaoVO;
	WebDriver driver;
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	
	
  public static Properties getProp() throws Exception{
		
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/login.properties");
		props.load(file);
		
		return props;
	}
	
	
	public void abreBrowser(){
		try{
			
			Properties prop = getProp();
		//driver.manage().window().maximize();
		//driver = new FirefoxDriver();
//		driver.manage().window().maximize();
		
		String driverChrome = prop.getProperty("prop.driverCrhome");
		
		 //String driverChrome = "C:\\chromedriver\\chromedriver.exe";
		   //String driverChrome = "C:\\firefoxDriver\\geckodriver.exe";
			if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
				System.setProperty(WEBDRIVER_CHROME_DRIVER, driverChrome);
			
			
			driver = new ChromeDriver();
			//driver.get("https://sigms-novo.des.coresp.caixa/sigms/");
			//driver.get(prop.getProperty("prop.url.des"));
			//driver.get("http://localhost:8080/sigms/");
			driver.get(prop.getProperty("prop.url.local")); 
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	@Test
	public void login(){
		
		try{	
			
			Properties prop = getProp();
			//LOCAL	
			
			//DES
			WebElement usuario = driver.findElement(By.name("username"));
			usuario.sendKeys(prop.getProperty("prop.usuario"));
			WebElement senha = driver.findElement(By.name("password"));
			senha.sendKeys(prop.getProperty("prop.senha"));
			senha.submit();
		}
		catch(Exception e){
			System.out.println("Link informado não encontrado.");
			driver.close();
		}
		
		//Resultado esperado
		boolean loginOk = driver.getPageSource().contains("Operador:");
		assertTrue(loginOk);
		//driver.quit();

	}
	
	public void fechaBrowser(){
		driver.quit();
	}
	
	@Test
	public void inclusao() {
		try {		
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[1]/a")).click();
			Select cbTpConta = new Select(driver.findElement(By.name("tipoContaSelecionada")));
			cbTpConta.selectByValue(AdesaoVO.getTipoConta());
			Thread.sleep(2000L);
			Select cbOp = new Select(driver.findElement(By.name("operacao")));
			cbOp.selectByValue(AdesaoVO.getOperacao());
			Thread.sleep(2000L);
			WebElement agencia = driver.findElement(By.name("agencia"));
			agencia.sendKeys(AdesaoVO.getAgencia());
			Thread.sleep(2000L);
			WebElement conta = driver.findElement(By.name("conta"));
			conta.sendKeys(AdesaoVO.getConta());
			Thread.sleep(2000L);
			WebElement cpfCnpj = driver.findElement(By.name("cpfCnpj"));
			cpfCnpj.sendKeys(AdesaoVO.getCpfCnpj());
			Thread.sleep(2000L);
			WebElement horaInicio = driver.findElement(By.name("horaInicioEnvio"));
			horaInicio.sendKeys(AdesaoVO.getHoraInicio());
			Thread.sleep(2000L);
			WebElement horaFinal = driver.findElement(By.name("horaFinalEnvio"));
			horaFinal.sendKeys(AdesaoVO.getHoraFinal());
			Thread.sleep(2000L);
			WebElement ddd = driver.findElement(By.name("ddd"));
			ddd.sendKeys(AdesaoVO.getDdd());
			Thread.sleep(2000L);
			WebElement telefone = driver.findElement(By.name("telefone"));
			telefone.sendKeys(AdesaoVO.getTelefone());
			Thread.sleep(2000L);
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByVisibleText(AdesaoVO.getValorMinimoGpDebito());
			Thread.sleep(2000L);
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByVisibleText(AdesaoVO.getValorMinimoCartaoDebito());
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(2000L);
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		//Resultado esperado
		boolean inclusaoOk = driver.getPageSource().contains("Adesão ao Serviço incluída com sucesso!");
		assertTrue(inclusaoOk);
		//driver.quit();
	}
	
	@Test
	public void alteracao() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			Thread.sleep(2000L);
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
			Thread.sleep(2000L);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[2]")).click();
			Select cbValorMinimoGpDebito = new Select(driver.findElement(By.name("minimoGrupoDebitoSelecionado")));
			cbValorMinimoGpDebito.selectByVisibleText(AdesaoVO.getValorMinimoGpDebito());
			Thread.sleep(2000L);
			Select cbValorMinimoCartaoDebito = new Select(driver.findElement(By.name("minimoPagamCartaoDebitoSelecionado")));
			cbValorMinimoCartaoDebito.selectByVisibleText(AdesaoVO.getValorMinimoCartaoDebito());
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(3000L);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean alteracaooOk = driver.getPageSource().contains("Adesão ao Serviço alterada com sucesso!");
		assertTrue(alteracaooOk);
		//driver.quit();
	}
	
	@Test
	public void consulta() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			Thread.sleep(2000L);
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
			Thread.sleep(2000L);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[1]")).click();
			Thread.sleep(3000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean consultaOk = driver.getPageSource().contains("Consulta de Adesão");
		assertTrue(consultaOk);
		//driver.quit();
	}
	
	@Test
	public void exclusao() {
		try {
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[2]/ul/li[2]/a")).click();
			Select cbIndicadorCpfCnpj = new Select(driver.findElement(By.name("indicadorCpfCnpj")));
			cbIndicadorCpfCnpj.selectByValue(AdesaoVO.getIndicadorCpfCnpj());
			Thread.sleep(2000L);
			WebElement cpfCnpf = driver.findElement(By.name("cpfCnpj"));
			cpfCnpf.sendKeys(AdesaoVO.getCpfCnpj());
			Thread.sleep(2000L);
			driver.findElement(By.id("botaoPesquisarAdesao")).click();
			driver.findElement(By.name("codigoAdesaoSelecionada")).click();
			driver.findElement(By.xpath("//*[@id=\"respostaConsultaAdesao\"]/div/div/input[3]")).click();
			driver.findElement(By.xpath("//*[@id=\"inclusaoAdesao\"]/div[1]/input")).click();
			Thread.sleep(2000L);
			driver.findElement(By.xpath("//*[@id=\"modalConfirmarAcao\"]")).click();
			Thread.sleep(3000L);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Resultado esperado
		boolean exclusaoOk = driver.getPageSource().contains("Adesão ao Serviço excluída com sucesso!");
		assertTrue(exclusaoOk);
		//driver.quit();
	}
}
