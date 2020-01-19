package operacaoProdutoAltera;

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

public class OperacaoProdutoAlteraPages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public OperacaoProdutoAlteraPages(WebDriver driver) {
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
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoOPAlteraPage novo() {

		try {

			System.out.println(driver.getCurrentUrl());

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[4]/a")).click();

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[4]/ul/li[2]/a")).click();
			Thread.sleep(1000);
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_PESQUISA_OP_3));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new NovoOPAlteraPage(driver);
	}

	public void resultadoAlteraOP(int codigo, String tipoConta, String tipoDocumento, String servicos,
			String servicosAssoc) throws Exception {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement inputCodigo = driver.findElement(By.name("produtoVO.codigo"));
			inputCodigo.getAttribute(String.valueOf(codigo));
			Thread.sleep(1000);
			Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
			cbTipoConta.selectByVisibleText(tipoConta);
			Thread.sleep(1000);
			Select cbTipoDocumento = new Select(driver.findElement(By.name("produtoVO.tipoPessoa")));
			cbTipoDocumento.selectByVisibleText(tipoDocumento);
			Thread.sleep(1000);
			Select cbServicos = new Select(driver.findElement(By.name("servicos")));
			cbServicos.selectByValue(servicos);
			Thread.sleep(2000);
			WebElement buttonAdicionarServico = driver.findElement(By.id("btnAdicionarServico"));
			buttonAdicionarServico.click();
			Thread.sleep(2000);
			Properties propScreenshotResultadoAlteracao = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotResultadoAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_RESULTADO_ALTERACAO_6));
			Select servicoAssoc = new Select(driver.findElement(By.id("servicosAssociados")));
			servicoAssoc.selectByValue(servicosAssoc);
			Thread.sleep(1000);
			WebElement buttonServicoAssocRemove = driver.findElement(By.id("btnRemoverServico"));
			buttonServicoAssocRemove.click();
			Thread.sleep(1000);
			WebElement buttonAltera = driver.findElement(By.id("btnAlterar"));
			buttonAltera.click();
			Thread.sleep(1000);
			print(propScreenshotResultadoAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_CONFIRMA_ALERACAO_7));
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
