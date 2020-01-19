package relatoriosTransacoesRejeitadas;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteRelatorioTransacoesRejeitadasPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatorioTransacoesRejeitadasPages relatorioTrnasacoesRejeitadas;

	public static void main(String[] args) {
		TesteRelatorioTransacoesRejeitadasPrincipal app = new TesteRelatorioTransacoesRejeitadasPrincipal();

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
		this.relatorioTrnasacoesRejeitadas = new RelatorioTransacoesRejeitadasPages(driver);
	}

	public void deveImprimir() {

		try {

			Properties prop = propriedade.loadProperties("relatorios.properties");

			relatorioTrnasacoesRejeitadas.visita();
			relatorioTrnasacoesRejeitadas.novo().preenche(
					prop.getProperty(PropKeys.PROP_RELATORIO_TRANSACOES_REJEITADAS_TIPO_RELATORIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_TRANSACOES_REJEITADAS_TIPO_SERVICO),
					prop.getProperty(PropKeys.PROP_RELATORIO_TRANSACOES_REJEITADAS_CATEGORIZACAO),
					prop.getProperty(PropKeys.PROP_RELATORIO_TRANSACOES_REJEITADAS_CANAL),
					prop.getProperty(PropKeys.PROP_RELATORIO_TRANSACOES_REJEITADAS_MOTIVO_REJEICAO));
			Properties propRelTransRej = propriedade.loadProperties("configuracaoPrint.properties");
			relatorioTrnasacoesRejeitadas
					.print(propRelTransRej.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_TRANSACOES_REJEITADA_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.relatorioTrnasacoesRejeitadas.getDriver().close();
	}

}
