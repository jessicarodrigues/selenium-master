package canal;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import propertiesArquivo.Screenshot;

public class TesteManterCanal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private CanalPages canal;
	Screenshot screen = new Screenshot(driver);

	public static void main(String[] args) throws Exception {

		TesteManterCanal app = new TesteManterCanal();

		try {
			app.abreNavegador();
			app.logarSigmsTesteCanal();
		} finally {
			app.closeWebDriver();
		}
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
			Properties prop = propriedade.loadProperties("canal.properties");
			canal.visita();
			canal.novo().cadastra(gerarCodigo(), prop.getProperty(PropKeys.PROP_MANTER_CANAL_INCLUSAO_SIGLA), true,
					prop.getProperty(PropKeys.PROP_MANTER_CANAL_INCLUSAO_DESCRICAO));
			Properties propCanalInclusaoSucesso = propriedade.loadProperties("configuracaoPrint.properties");
			canal.print(propCanalInclusaoSucesso.getProperty(PropKeys.PROP_PRINT_SCREEN_CANAL_INCLUSAO_MSG_FEEDBACK_5));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.canal.getDriver().close();
	}

}
