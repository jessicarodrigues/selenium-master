package subservicoConsulta;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteConsultaSubServicoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultaSubServicosPages subServicos;

	public static void main(String[] args) throws Exception {
		TesteConsultaSubServicoPrincipal app = new TesteConsultaSubServicoPrincipal();

		try {
			app.abreNavegador();
			app.deveConsultarSubServico();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.subServicos = new ConsultaSubServicosPages(driver);
	}

	public void deveConsultarSubServico() {
		try {
			Properties prop = propriedade.loadProperties("servicos.properties");
			subServicos.visita();
			subServicos.novo().pesquisaSubServicos(prop.getProperty(PropKeys.PROP_CONSULTA_SUB_SERVICO_CATEGORIA),
					prop.getProperty(PropKeys.PROP_CONSULTA_SUB_SERVICO_SERVICOS));
			subServicos.consultarSubservicos(prop.getProperty(PropKeys.PROP_CONSULTA_SUB_SERVICO_SUB_SERVICOS));
			Properties propSubServicos = propriedade.loadProperties("configuracaoPrint.properties");
			subServicos
					.print(propSubServicos.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_CONSULTA_RESULTADO_CONSULTA_7));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.subServicos.getDriver().close();
	}

}
