package relatorioExclusaoAdesao;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import propertiesArquivo.Screenshot;

public class RelatorioExclusaoDeAdesaoPages {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private String baseUrl;
	private static final String SIGMS_URL = "sigms.url";
	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

	public RelatorioExclusaoDeAdesaoPages(WebDriver driver) {
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
			print(propScreenshotLogin.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_EXCLUSAO_ADESAO_LOGIN_1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public NovoRelatorioExclusaoPage novo() {

		try {

			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul/li[2]/a"));
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[7]/a")).click();

			Properties propScreenshotMenu = propriedade.loadProperties("configuracaoPrint.properties");
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_EXCLUSAO_ADESAO_MENU_2));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"menu_mobile\"]/ul[1]/li[7]/ul/li[3]/a")).click();
			print(propScreenshotMenu.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_EXCLUSAO_ADESAO_TELA_REL_3));
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new NovoRelatorioExclusaoPage(driver);

	}

	public void print(String nomeArquivo) {
		try {
			Properties propDiretorioRelatorio = propriedade.loadProperties("configuracaoPrint.properties");
			new Screenshot(driver).captureScreen(
					propDiretorioRelatorio.getProperty(PropKeys.PROP_PRINT_SCREEN_DIRETORIO_RELATORIOS), nomeArquivo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
