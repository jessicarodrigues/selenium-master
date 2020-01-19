package canal;

import static org.junit.Assert.assertTrue;

import java.util.Properties;
import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteMenuCanal2_teste {

	ArquivoPropertie propriedade = new ArquivoPropertie();

	private WebDriver driver;
	private CanalPages canal;

	public static void main(String[] args) throws Exception {

		TesteMenuCanal2_teste app = new TesteMenuCanal2_teste();

		try {
			app.abreNavegador();
			app.logarSigmsTesteCanal();
		} finally {
			app.closeWebDriver();
		}
	}

	public void closeWebDriver() {
		this.canal.getDriver().close();
	}

	public void abreNavegador() {

		this.canal = new CanalPages(driver);
	}

	public int gerarCodigo() {
		Random gerador = new Random();

		int numero = gerador.nextInt(501);

		System.out.println(numero);
		return numero;
	}

	public void logarSigmsTesteCanal() {
		try {
			Properties prop = propriedade.getPropCanal();
			canal.visita();
			canal.novo().cadastra(gerarCodigo(), prop.getProperty(PropKeys.PROP_MANTER_CANAL_INCLUSAO_SIGLA), true,
					prop.getProperty(PropKeys.PROP_MANTER_CANAL_INCLUSAO_DESCRICAO));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
