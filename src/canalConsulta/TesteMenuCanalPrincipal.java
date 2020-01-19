package canalConsulta;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteMenuCanalPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();

	private WebDriver driver;
	private CanalPagesConsulta canal;

	public static void main(String[] args) throws Exception {

		TesteMenuCanalPrincipal app = new TesteMenuCanalPrincipal();

		try {
			app.abreNavegador();
			app.deveConsultar();

		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.canal = new CanalPagesConsulta(driver);

	}

	public void deveConsultar() {

		try {
			Properties props = propriedade.getPropCanalConsulta();
			canal.visita();
			canal.novo().ConsultaCanal(props.getProperty(PropKeys.PROP_MANTER_CANAL_CONSULTA_CANAL));
			// canal.ResultadoConsulta(10, "Teste Remodelagem", true, "Teste
			// Remodelagem");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.canal.getDriver().close();
	}
}
