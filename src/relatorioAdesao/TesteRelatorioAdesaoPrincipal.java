package relatorioAdesao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteRelatorioAdesaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatorioAdesaoPages relatorioAdesao;

	public static void main(String[] args) throws Exception {
		TesteRelatorioAdesaoPrincipal app = new TesteRelatorioAdesaoPrincipal();

		try {
			app.abreNavegador();
			app.deveImprimir();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.relatorioAdesao = new RelatorioAdesaoPages(driver);
	}

	public void deveImprimir() {

		try {
			Properties prop = propriedade.loadProperties("relatorios.properties");
			relatorioAdesao.visita();
			relatorioAdesao.novo().preenche(prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_TIPO_RELATORIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_TIPO_SERVICO),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_CATEGORIZACAO),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_CANAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_DT_INICIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_DT_FINAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_SUPERINTENDENCIA),
					prop.getProperty(PropKeys.PROP_RELATORIO_ADESAO_AGENCIA));
			Properties propRelAdesao = propriedade.loadProperties("configuracaoPrint.properties");
			relatorioAdesao
					.print(propRelAdesao.getProperty(PropKeys.PROP_PRINT_SCREEN_ADESAO_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.relatorioAdesao.getDriver().close();
	}
}
