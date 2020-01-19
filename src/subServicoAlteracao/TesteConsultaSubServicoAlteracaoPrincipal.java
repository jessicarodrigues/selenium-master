package subServicoAlteracao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteConsultaSubServicoAlteracaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultaSubServicosAlteracaoPages alteracaoSubServico;

	public static void main(String[] args) throws Exception {

		TesteConsultaSubServicoAlteracaoPrincipal app = new TesteConsultaSubServicoAlteracaoPrincipal();

		try {
			app.abreNavegador();
			app.deveAlterarSubServico();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.alteracaoSubServico = new ConsultaSubServicosAlteracaoPages(driver);
	}

	public void deveAlterarSubServico() {

		try {

			Properties prop = propriedade.loadProperties("servicos.properties");
			alteracaoSubServico.visita();
			alteracaoSubServico.novo().alteraSubServico(prop.getProperty(PropKeys.PROP_ALTERA_SUB_SERVICO_CATEGORIA),
					prop.getProperty(PropKeys.PROP_ALTERA_SUB_SERVICO_SERVICO));
			alteracaoSubServico.consultarSubservicosAlteracao(prop.getProperty(PropKeys.PROP_ALTERA_SUB_SERVICO_SUB_SERVICO));
			alteracaoSubServico
					.resultadoAlteracaoSubServico(prop.getProperty(PropKeys.PROP_ALTERA_SUB_SERVICO_DESCSUB_SERVICO_RESULT));
			Properties propSubServicos = propriedade.loadProperties("configuracaoPrint.properties");
			alteracaoSubServico
					.print(propSubServicos.getProperty(PropKeys.PROP_PRINT_SCREEN_SUB_SERVICOS_ALTERACAO_MSG_FEEDBACK_11));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.alteracaoSubServico.getDriver().close();
	}

}
