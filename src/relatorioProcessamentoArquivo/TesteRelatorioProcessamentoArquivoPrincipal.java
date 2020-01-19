package relatorioProcessamentoArquivo;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteRelatorioProcessamentoArquivoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private RelatorioProcessamentoArquivoPages processamentoArquivo;

	public static void main(String[] args) throws Exception {

		TesteRelatorioProcessamentoArquivoPrincipal app = new TesteRelatorioProcessamentoArquivoPrincipal();

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
		this.processamentoArquivo = new RelatorioProcessamentoArquivoPages(driver);
	}

	public void deveImprimir() {

		try {
			Properties prop = propriedade.loadProperties("relatorios.properties");
			processamentoArquivo.visita();
			processamentoArquivo.novo().preenche(prop.getProperty(PropKeys.PROP_RELATORIO_PROCESSAMENTO_ARQUIVO_STATUS_ARQ),
					prop.getProperty(PropKeys.PROP_RELATORIO_PROCESSAMENTO_ARQUIVO_TIPO_ARQUIVO),
					prop.getProperty(PropKeys.PROP_RELATORIO_PROCESSAMENTO_ARQUIVO_DT_INICIO),
					prop.getProperty(PropKeys.PROP_RELATORIO_PROCESSAMENTO_ARQUIVO_DT_FINAL));
			Properties propRelProcessArq = propriedade.loadProperties("configuracaoPrint.properties");
			processamentoArquivo
					.print(propRelProcessArq.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_PROCESS_ARQUIVO_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.processamentoArquivo.getDriver().close();
	}

}
