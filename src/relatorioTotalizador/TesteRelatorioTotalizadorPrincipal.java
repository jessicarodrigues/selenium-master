package relatorioTotalizador;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteRelatorioTotalizadorPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatoriosTotalizadorPages relatorioTotalizador;

	public static void main(String[] args) throws Exception {

		TesteRelatorioTotalizadorPrincipal app = new TesteRelatorioTotalizadorPrincipal();

		try {
			app.abreNavegador();
			app.deveImprimir();

		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {

		this.relatorioTotalizador = new RelatoriosTotalizadorPages(driver);
	}

	public void deveImprimir() {

		try {

			Properties prop = propriedade.loadProperties("relatorios.properties");
			relatorioTotalizador.visita();
			relatorioTotalizador.novo().preenche(prop.getProperty(PropKeys.PROP_RELATORIO_TOTALIZADOR_DT_INICIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_TOTALIZADOR_DT_FINAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_TOTALIZADOR_TIPO_MENSAGEM),
			        prop.getProperty(PropKeys.PROP_RELATORIO_TOTALIZADOR_TIPO_SERVICO),
			        prop.getProperty(PropKeys.PROP_RELATORIO_TOTALIZADOR_CATEGORIZACAO));
			Properties propMsgsEnv = propriedade.loadProperties("configuracaoPrint.properties");
			relatorioTotalizador
					.print(propMsgsEnv.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_TOTALIZADOR_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.relatorioTotalizador.getDriver().close();
	}

}
