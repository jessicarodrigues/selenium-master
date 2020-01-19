package consultaMsgsEnviadas;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteConsultaMsgEnviadaPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultaMensagensEnviadasPages consultaMsgsEnviadas;

	public static void main(String[] args) throws Exception {

		TesteConsultaMsgEnviadaPrincipal app = new TesteConsultaMsgEnviadaPrincipal();

		try {
			app.abreNavegador();
			app.deveConsultar();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {

		consultaMsgsEnviadas = new ConsultaMensagensEnviadasPages(driver);
	}

	public void deveConsultar() {
		try {
			Properties prop = propriedade.loadProperties("consultaMsgsEnviadas.properties");
			consultaMsgsEnviadas.visita();
			consultaMsgsEnviadas.novo().preenche(prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_FORMA_CONSULTA),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_CPF_CNPJ_NIS), 
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_DDD),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_NUMERO),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_TIPO_SERVICO),
					prop.getProperty(PropKeys.PROP_MSGS_ENVIADAS_SUB_SERVICO));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.consultaMsgsEnviadas.getDriver().close();
	}
}
