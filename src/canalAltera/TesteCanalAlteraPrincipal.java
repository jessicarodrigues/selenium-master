package canalAltera;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteCanalAlteraPrincipal {
	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private CanalPagesAltera canal;

	public static void main(String[] args) throws Exception {

		TesteCanalAlteraPrincipal app = new TesteCanalAlteraPrincipal();
		try {
			app.abreNavegador();
			app.deveAlterar();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.canal = new CanalPagesAltera(driver);
	}

	public void deveAlterar() {
		try {
			Properties prop = propriedade.getPropCanalAltera();
			canal.visita();
			canal.novo().Altera(prop.getProperty(PropKeys.PROP_MANTER_CANAL_ALTERA_CANAL));
			canal.resultadoAltera(436, prop.getProperty(PropKeys.PROP_MANTER_CANAL_ALTERA_CANAL_SIGLA),
					prop.getProperty(PropKeys.PROP_MANTER_CANAL_ALTERA_CANAL_DESCRICAO));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.canal.getDriver().close();
	}
}
