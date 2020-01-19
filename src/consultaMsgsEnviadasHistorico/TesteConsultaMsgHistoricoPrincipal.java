package consultaMsgsEnviadasHistorico;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import consultaMsgsEnviadas.TesteConsultaMsgEnviadaPrincipal;
import propertiesArquivo.ArquivoPropertie;

public class TesteConsultaMsgHistoricoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultaMsgsHistoricoPages consultaMsgsHistorico;

	public static void main(String[] args) {
		TesteConsultaMsgHistoricoPrincipal app = new TesteConsultaMsgHistoricoPrincipal();

		try {
			app.abreNavegador();
			app.deveConsultar();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		consultaMsgsHistorico = new ConsultaMsgsHistoricoPages(driver);
	}

	public void deveConsultar() {
		try {
			Properties prop = propriedade.loadProperties("consultaMsgsEnviadasHistorico.properties");
			consultaMsgsHistorico.visita();
			consultaMsgsHistorico.novo().preenche(
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_FORMA_CONSULTA),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_DT_INICIAL),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_DT_FINAL),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_AGENCIA),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_CONTA),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_OPERACAO_PRODUTO),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_CPF_CNPJ_NIS),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_DDD),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_NUMERO),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_TIPO_SERVICO),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_HISTORICO_SUB_SERVICO));
			Properties propMsgsEnv = propriedade.loadProperties("configuracaoPrint.properties");
			consultaMsgsHistorico
					.print(propMsgsEnv.getProperty(PropKeys.PROP_PRINT_SCREEN_MSGS_ENVIADAS_HISTORICO_DOWNLOAD_5));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.consultaMsgsHistorico.getDriver().close();
	}

}
