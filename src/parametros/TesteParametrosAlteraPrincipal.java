package parametros;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteParametrosAlteraPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ParametrosPagesAltera parametros;

	public static void main(String[] args) throws Exception {
		TesteParametrosAlteraPrincipal app = new TesteParametrosAlteraPrincipal();

		try {
			app.abreNavegador();
			app.deveAlterar();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.parametros = new ParametrosPagesAltera(driver);
	}

	public void deveAlterar() {
		try {
			Properties prop = propriedade.getPropParametros();
			parametros.visita();
			parametros.novo().altera(prop.getProperty(PropKeys.PROP_PARAMETROS_INTERVALO_TEMPO),
					prop.getProperty(PropKeys.PROP_PARAMETROS_HORARIO_DISP_INICIAL),
					prop.getProperty(PropKeys.PROP_PARAMETROS_DIAS_ARMAZ_ADESOES_INAT),
					prop.getProperty(PropKeys.PROP_PARAMETROS_VALOR_MIN_SISTEMA),
					prop.getProperty(PropKeys.PROP_PARAMETROS_NUM_TENT),
					prop.getProperty(PropKeys.PROP_PARAMETROS_HORARIO_DISP_FINAL),
					prop.getProperty(PropKeys.PROP_PARAMETROS_DIAS_ARMZ_NOTIFI),
					prop.getProperty(PropKeys.PROP_PARAMETROS_DIAS_SEM_ENVIO));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void closeWebDriver() {
		this.parametros.getDriver().close();
	}
}
