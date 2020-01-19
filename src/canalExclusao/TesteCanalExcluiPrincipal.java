package canalExclusao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteCanalExcluiPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();

	private WebDriver driver;
	private CanalPagesDelete canal;

	public static void main(String[] args) throws Exception {

		TesteCanalExcluiPrincipal app = new TesteCanalExcluiPrincipal();

		try {
			app.abreNavegador();
			app.deveExcluir();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.canal = new CanalPagesDelete(driver);
	}

	public void deveExcluir() {
		try {
			Properties prop = propriedade.getPropCanalExclusao();
			canal.visita();
			canal.novo().exclui(prop.getProperty(PropKeys.PROP_MANTER_CANAL_EXCLUSAO_CANAL));
			canal.resultadoExclusao(436, prop.getProperty(PropKeys.PROP_MANTER_CANAL_EXCLUI_CANAL_SIGLA), true,
					prop.getProperty(PropKeys.PROP_MANTER_CANAL_EXCLUI_CANAL_DESCRICAO));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.canal.getDriver().close();
	}
}
