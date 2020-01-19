package relatorioNormasEliminacao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;


public class TesteRelatorioNormasEliminacaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatorioNormasEliminacaoPages relatorioNormasEli;

	public static void main(String[] args) {
		TesteRelatorioNormasEliminacaoPrincipal app = new TesteRelatorioNormasEliminacaoPrincipal();

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
		this.relatorioNormasEli = new RelatorioNormasEliminacaoPages(driver);
	}

	public void deveImprimir() {

		try {

			Properties prop = propriedade.loadProperties("relatorios.properties");
			                                  
			relatorioNormasEli.visita(); 
			relatorioNormasEli.novo().preenche(prop.getProperty(PropKeys.PROP_RELATORIO_NORMAS_ELI_DT_INICIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_NORMAS_ELI_DT_FINAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_NORMAS_ELI_DESCRICAO),
					prop.getProperty( PropKeys.PROP_RELATORIO_NORMAS_ELI_SITUACAO));
			Properties propRelnormasEli = propriedade.loadProperties("configuracaoPrint.properties");
			relatorioNormasEli
					.print(propRelnormasEli.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_NORMAS_ELI_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void closeWebDriver() {
		this.relatorioNormasEli.getDriver().close();
	}

}
