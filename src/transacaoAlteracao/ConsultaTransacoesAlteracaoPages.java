package transacaoAlteracao;

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

public class ConsultaTransacoesAlteracaoPages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public ConsultaTransacoesAlteracaoPages(WebDriver driver) {
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
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoTransacoesAlteracaoPage novo() {
		try {

			System.out.println(driver.getCurrentUrl());

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));

			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/a")).click();

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[1]/ul/li/a")).click();
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_TELA_PESQUISA_3));
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new NovoTransacoesAlteracaoPage(driver);
	}

	public void consultarSubServicoSelecionadoAltercao(String subServicos) {

		try {
			Select cbSubServico = new Select(driver.findElement(By.id("subServicos")));
			cbSubServico.selectByVisibleText(subServicos);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_RESULTADO_PESQUISA_5));
			WebElement buttonConsultarSubServicoAlteracao = driver.findElement(By.id("btnConsultarSubServico"));
			buttonConsultarSubServicoAlteracao.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastraNovaTransacao(int codigo, String descricao, String tipoRecebimento, String tipoEnvioBroker,
			String tipoTransacao, String mascaraDeMensagens) {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Properties propScreenshotCriaNova = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotCriaNova.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CADASTRA_TELA_CRIA_NOVA_1));

			WebElement buttonNovaTransacao = driver.findElement(By.id("btnIncluirNovaTransacao"));
			buttonNovaTransacao.click();
			Thread.sleep(2000);
			print(propScreenshotCriaNova
					.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CADASTRA_INCLUSAO_TRANSACAO_2));
			WebElement inputCodigo = driver.findElement(By.id("codigoTransacao"));
			inputCodigo.sendKeys(String.valueOf(codigo));
			Thread.sleep(2000);
			WebElement inputDescricao = driver.findElement(By.id("descricao"));
			inputDescricao.sendKeys(descricao);
			Thread.sleep(2000);
			Select cbTipoRecebimento = new Select(driver.findElement(By.id("tipoRecebimento")));
			cbTipoRecebimento.selectByVisibleText(tipoRecebimento);
			Thread.sleep(2000);
			Select cbTipoEnvioBroker = new Select(driver.findElement(By.id("tipoProcessamentoNotificacao")));
			cbTipoEnvioBroker.selectByVisibleText(tipoEnvioBroker);
			Thread.sleep(2000);
			Select cbTipoTransacao = new Select(
					driver.findElement(By.name("relacionamentoSubServicoTransacaoVO.transacao.tipoTransacao")));
			cbTipoTransacao.selectByValue(tipoTransacao);
			Thread.sleep(2000);
			WebElement txtMascaraMsg = driver.findElement(By.id("mascaraMensagens"));
			txtMascaraMsg.sendKeys(mascaraDeMensagens);
			Thread.sleep(2000);
			print(propScreenshotCriaNova.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CADASTRA_PREENCHE_CAMPOS_3));
			driver.findElement(By.xpath("//*[@id=\"formManterTransacao\"]/div[1]/div[9]/input")).click();
			Thread.sleep(2000);
			print(propScreenshotCriaNova
					.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CADASTRA_CONFIRMA_INCLUSAO_4));
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(2000);
			WebElement buttonVoltarListaSub = driver.findElement(By.id("btnVoltarTelaSubServico"));
			buttonVoltarListaSub.click();
			Thread.sleep(2000);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void consultarTransacaoAssociadaAlteraco(String transacaoAssociada) {

		try {
			Select cbTransacaoAssociadas = new Select(driver.findElement(By.id("transacoesAssociadas")));
			cbTransacaoAssociadas.selectByVisibleText(transacaoAssociada);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_CONSULTA_TRANSACAO_6));
			WebElement buttonConsultarTransacao = driver.findElement(By.id("btnConsultarTransacao"));
			buttonConsultarTransacao.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterarTransacao(String descricao, String tipoRecebimento, String envioAoBroker, String tipoTransacao,
			String mascaraMensagens) {

		try {

			driver.findElement(By.xpath("//*[@id=\"formManterTransacao\"]/div[1]/div[9]/a")).click();

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement inputDescricao = driver.findElement(By.id("descricao"));
			inputDescricao.clear();
			Thread.sleep(2000);
			Select cbTipoRecebimento = new Select(driver.findElement(By.id("tipoRecebimento")));
			cbTipoRecebimento.getFirstSelectedOption();
			Thread.sleep(2000);
			Select cbTipoEnvioBroker = new Select(driver.findElement(By.id("tipoProcessamentoNotificacao")));
			cbTipoEnvioBroker.getFirstSelectedOption();
			Thread.sleep(2000);
			Select cbTipoTransacao = new Select(
					driver.findElement(By.name("relacionamentoSubServicoTransacaoVO.transacao.tipoTransacao")));
			cbTipoTransacao.getFirstSelectedOption();
			Thread.sleep(2000);
			WebElement inputMascaraMensagens = driver.findElement(By.id("mascaraMensagens"));
			inputMascaraMensagens.clear();
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_RESULTADO_CONSULTA_7));

			/* Novos valores */

			WebElement editDescricao = driver.findElement(By.id("descricao"));
			editDescricao.sendKeys(descricao);
			Thread.sleep(2000);
			Select editCbTipoRecebimento = new Select(driver.findElement(By.id("tipoRecebimento")));
			editCbTipoRecebimento.selectByVisibleText(tipoRecebimento);
			Thread.sleep(2000);
			Select editCbTipoEnvioBroker = new Select(driver.findElement(By.id("tipoProcessamentoNotificacao")));
			editCbTipoEnvioBroker.selectByVisibleText(envioAoBroker);
			Thread.sleep(2000);
			Select editCbTipoTransacao = new Select(
					driver.findElement(By.name("relacionamentoSubServicoTransacaoVO.transacao.tipoTransacao")));
			editCbTipoTransacao.selectByVisibleText(tipoTransacao);
			Thread.sleep(2000);
			WebElement editInputMascaraMensagens = driver.findElement(By.id("mascaraMensagens"));
			editInputMascaraMensagens.sendKeys(mascaraMensagens);
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_TELA_ALTERACAO_8));
			driver.findElement(By.xpath("//*[@id=\"formManterTransacao\"]/div[1]/div[9]/input")).click();
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_CONFIRMA_ALTERACAO_9));
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(2000);
			WebElement buttonVoltar = driver.findElement(By.id("btnVoltarTelaSubServico"));
			buttonVoltar.click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluiTransacao() {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_EXCLUI_TELA_EXCLUSAO_1));
			Thread.sleep(2000);
			WebElement buttonExcluiTransacao = driver.findElement(By.id("btnExcluirTransacao"));
			buttonExcluiTransacao.click();
			Thread.sleep(2000);
			print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_EXCLUI_CONFIRMA_EXCLUSAO_2));
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
