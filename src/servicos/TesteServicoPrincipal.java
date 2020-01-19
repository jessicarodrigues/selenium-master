package servicos;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteServicoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ServicosPages servicos;

	public static void main(String[] args) throws Exception {
		TesteServicoPrincipal app = new TesteServicoPrincipal();

		app.abreNavegador();
		app.deveConsultar();
		app.closeWebDriver();
	}

	public void abreNavegador() {
		this.servicos = new ServicosPages(driver);
	}

	public void deveConsultar() {
		try {
			Properties prop = propriedade.loadProperties("servicos.properties");
			servicos.visita();
			servicos.novo().pesquisaServicos(prop.getProperty(PropKeys.PROP_PESQUISA_SERVICO_CATEGORIA),
					prop.getProperty(PropKeys.PROP_PESQUISA_SERVICO_SERVICOS));
			servicos.alteraPesquisa(prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_CATEGORIA),
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_DESCRICAO_SERVICO), true,
					Double.parseDouble((prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_VALOR))), false,
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_FAIXA_VALORES),
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_MSG_ADESAO_INCLUSAO),
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_MSG_ADESAO_ALTERACAO),
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_MSG_ADESAOEXCLUSAO),
					prop.getProperty(PropKeys.PROP_ALTERA_SERVICO_SUB_SERVICO));
			Properties propServicos = propriedade.loadProperties("configuracaoPrint.properties");
			servicos
					.print(propServicos.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_MSG_FEEDBACK_10));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void closeWebDriver() {
		this.servicos.getDriver().close();
	}

}
