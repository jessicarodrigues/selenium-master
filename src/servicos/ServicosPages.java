package servicos;

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

public class ServicosPages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public ServicosPages(WebDriver driver) {
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
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoPageServico novo() {

		try {
			System.out.println(driver.getCurrentUrl());

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/a")).click();

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/ul/li/a")).click();
			Thread.sleep(1000);
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_TELA_PESQUISA_3));
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new NovoPageServico(driver);
	}

	public void alteraPesquisa(String categoria, String descricaoServico, boolean habilitado, double valor,
			boolean adesaoObrigatoria, String faixaValores, String msgInclusao, String msgAlteracao, String msgExclusao,
			String subServicos) {

		try {
			driver.findElement(By.xpath("//*[@id=\"btnsAcoes\"]/a[1]")).click();

			Properties propScreenshotTelaAlteracao = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotTelaAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_TELA_ALTERACAO_6));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			Select cbCategoria = new Select(driver.findElement(By.id("categoria")));
			cbCategoria.selectByVisibleText(categoria);
			Thread.sleep(2000);
			WebElement inputDescricaoServico = driver.findElement(By.id("descricaoServico"));
			inputDescricaoServico.getAttribute(descricaoServico);
			Thread.sleep(2000);
			if (habilitado) {
				WebElement ckHabilitado = driver.findElement(By.id("servicoHabilitado"));
				ckHabilitado.click();
			}

			WebElement inputValor = driver.findElement(By.id("valor"));
			inputValor.sendKeys(String.valueOf(valor));
			Thread.sleep(2000);
			WebElement buttonAdicionarValor = driver.findElement(By.id("btnAdicionarValorServico"));
			buttonAdicionarValor.click();
			Thread.sleep(2000);
			if (adesaoObrigatoria) {
				WebElement ckAdesaoObrigatoria = driver.findElement(By.id("adesaoObrigatoria"));
				ckAdesaoObrigatoria.click();
			}

			Select cbFaixaValores = new Select(driver.findElement(By.id("faixaValores")));
			cbFaixaValores.selectByVisibleText(faixaValores);
			Thread.sleep(2000);
			WebElement buttonRemoveFaixaValor = driver.findElement(By.id("btnRemoverValorServico"));
			buttonRemoveFaixaValor.click();
			Thread.sleep(2000);
			WebElement txtMsgInclusao = driver.findElement(By.id("mensagemInclusao"));
			txtMsgInclusao.clear();
			Thread.sleep(2000);
			WebElement txtMsgAletracao = driver.findElement(By.id("mensagemAlteracao"));
			txtMsgAletracao.clear();
			Thread.sleep(2000);
			WebElement txtMsgExclusao = driver.findElement(By.name("servicoSelecionado.layoutMensagemExclusaoAdesao"));
			txtMsgExclusao.clear();
			Thread.sleep(2000);
			Select cbSubServicos = new Select(driver.findElement(By.id("subServicos")));
			cbSubServicos.getAllSelectedOptions();
			Thread.sleep(2000);
			print(propScreenshotTelaAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_LIMPA_CAMPOS_7));

			/* Novos valores da alteracao */


			WebElement editMsgInclusao = driver.findElement(By.id("mensagemInclusao"));
			editMsgInclusao.sendKeys(msgInclusao);
			WebElement editMsgAlteracao = driver.findElement(By.id("mensagemAlteracao"));
			editMsgAlteracao.sendKeys(msgAlteracao);
			Thread.sleep(2000);
			WebElement editMsgExclusao = driver.findElement(By.name("servicoSelecionado.layoutMensagemExclusaoAdesao"));
			editMsgExclusao.sendKeys(msgExclusao);
			print(propScreenshotTelaAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_PREENCHE_CAMPOS_8));
			Thread.sleep(2000);
			WebElement buttonSalvar = driver.findElement(By.id("btnSalvarServico"));
			buttonSalvar.click();
			print(propScreenshotTelaAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_CONFIRMA_ALTERACAO_9));
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
