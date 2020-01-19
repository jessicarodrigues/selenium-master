package relatorioExclusaoAdesao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteRelatorioExclusaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatorioExclusaoDeAdesaoPages relatorioExclusao;

	public static void main(String[] args) throws Exception {

		TesteRelatorioExclusaoPrincipal app = new TesteRelatorioExclusaoPrincipal();

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
		this.relatorioExclusao = new RelatorioExclusaoDeAdesaoPages(driver);
	}

	public void deveImprimir() {

		try {
			Properties prop = propriedade.loadProperties("relatorios.properties");

			relatorioExclusao.visita();
			relatorioExclusao.novo().preenche(prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_TIPO_RELATORIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_TIPO_SERVICO),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_CATEGORIZACAO),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_CANAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_DT_INICIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_DT_FINAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_SUPERINTENDENCIA),
					prop.getProperty(PropKeys.PROP_RELATORIO_EXCLUSAO_ADESAO_AGENCIA));
			Properties propRelExclAdesao = propriedade.loadProperties("configuracaoPrint.properties");
			relatorioExclusao
					.print(propRelExclAdesao.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_EXCLUSAO_ADESAO_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.relatorioExclusao.getDriver().close();
	}
}
