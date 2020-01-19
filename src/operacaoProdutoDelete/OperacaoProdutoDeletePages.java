package operacaoProdutoDelete;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import propertiesArquivo.Screenshot;

public class OperacaoProdutoDeletePages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public OperacaoProdutoDeletePages(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {

		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			Properties prop = propriedade.loadProperties("login.properties");
			if (System.getProperty(SIGMS_URL) == null)
				baseUrl = prop.getProperty(PropKeys.PROP_LOGIN_URL);
			else
				baseUrl = System.getProperty(SIGMS_URL);

			if (System.getProperty(WEBDRIVER_CHROME_DRIVER) == null)
				System.setProperty(WEBDRIVER_CHROME_DRIVER, prop.getProperty(PropKeys.PROP_LOGIN_DRIVER_CRHOME));

			driver = new ChromeDriver(options);
			driver.get(baseUrl);

			driver.findElement(By.id("login-username")).sendKeys(prop.getProperty(PropKeys.PROP_LOGIN_USUARIO));
			driver.findElement(By.id("login-password")).sendKeys(prop.getProperty(PropKeys.PROP_LOGIN_SENHA));
			driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[3]/input")).click();
			Thread.sleep(1000);

			Properties propScreenshotLogin = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoOPDeletePage novo() {
		try {
			System.out.println(driver.getCurrentUrl());

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[4]/a")).click();
			Thread.sleep(1000);

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[4]/ul/li[2]/a")).click();
			Thread.sleep(1000);
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_PESQUISA_OP_3));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new NovoOPDeletePage(driver);
	}

	public void resultadoExclusao(String codigo, String tipoConta, String tipoDocumento, String servicos,
			String servicosAssoc) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement inputCodigo = driver.findElement(By.name("produtoVO.codigo"));
			inputCodigo.getAttribute(String.valueOf(codigo));

			Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
			cbTipoConta.getAllSelectedOptions();

			Select cbTipoDocumento = new Select(driver.findElement(By.name("produtoVO.tipoPessoa")));
			cbTipoDocumento.getAllSelectedOptions();
			Thread.sleep(1000);
			Select cbServicos = new Select(driver.findElement(By.name("servicos")));
			cbServicos.getAllSelectedOptions();
			Thread.sleep(1000);
			Select servicoAssoc = new Select(driver.findElement(By.id("servicosAssociados")));
			servicoAssoc.getAllSelectedOptions();
			Thread.sleep(1000);
			WebElement buttonConfirmaExclusao = driver.findElement(By.id("btnExcluir"));
			buttonConfirmaExclusao.click();
			Thread.sleep(1000);
			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu
					.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_CONFIRMA_EXCLUSAO_6));
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print(String nomeArquivo) {
		try {
			Properties propDiretorioOP = propriedade.loadProperties("configuracaoPrint.properties");
			new Screenshot(driver).captureScreen(
					propDiretorioOP.getProperty(PropKeys.PROP_PRINT_SCREEN_DIRETORIO_OPERACAO_PRODUTO), nomeArquivo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}
}
