package subServicoAlteracao;

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

public class ConsultaSubServicosAlteracaoPages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public ConsultaSubServicosAlteracaoPages(WebDriver driver) {
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
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoConsultaSubServicosAlteracaoPage novo() {

		try {
			System.out.println(driver.getCurrentUrl());

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/a")).click();

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/ul/li/a")).click();
			Thread.sleep(1000);
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_TELA_PESQUISA_3));
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new NovoConsultaSubServicosAlteracaoPage(driver);

	}

	public void consultarSubservicosAlteracao(String subServicos) {

		try {
			Select cbSubServico = new Select(driver.findElement(By.id("subServicos")));
			cbSubServico.selectByValue(subServicos);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_TELA_ALTERACAO_6));
			WebElement buttonConsultarSubServicoAlteracao = driver.findElement(By.id("btnConsultarSubServico"));
			buttonConsultarSubServicoAlteracao.click();
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_LIMPA_CAMPOS_7));
			driver.findElement(By.xpath("//*[@id=\"manterServicoVO\"]/div[4]/div/a")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resultadoAlteracaoSubServico(String descricaoSubServico) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement clearDescricaoServico = driver.findElement(By.id("descricaoSubServico"));
			clearDescricaoServico.clear();
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_PREENCHE_CAMPOS_8));

			/* Novo valor da descricao */
			WebElement inputDescricaoServico = driver.findElement(By.name("subServicoSelecionado.nomeSubServico"));
			inputDescricaoServico.sendKeys(descricaoSubServico);
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_CONFIRMA_ALTERACAO_9));
			WebElement buttonSalvarSubServico = driver.findElement(By.id("btnSalvarSubServico"));
			buttonSalvarSubServico.click();
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_CONFIRMA_10));
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print(String nomeArquivo) {
		try {
			Properties propDiretorioServicos = propriedade.loadProperties("configuracaoPrint.properties");
			new Screenshot(driver).captureScreen(
					propDiretorioServicos.getProperty(PropKeys.PROP_PRINT_SCREEN_DIRETORIO_SERVICOS), nomeArquivo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
