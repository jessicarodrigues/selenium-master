package transacaoConsulta;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteConsultaTransacaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultarTransacoesPages transacoes;

	public static void main(String[] args) throws Exception {

		TesteConsultaTransacaoPrincipal app = new TesteConsultaTransacaoPrincipal();

		try {
			app.abreNavegador();
			app.deveConsultarTransacao();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.transacoes = new ConsultarTransacoesPages(driver);
	}

	public void deveConsultarTransacao() {
		try {
			Properties prop = propriedade.loadProperties("transacao.properties");
			transacoes.visita();
			transacoes.novo().consultaSubServicoTransacao(prop.getProperty(PropKeys.PROP_TRANSACAO_CONSULTA_CATEGORIA),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CONSULTA_SERVICO));
			transacoes.consultarSubServicoSelecionado(
					prop.getProperty(PropKeys.PROP_TRANSACAO_CONSULTA_SERVICOSELECIONADO_SUB_SERVICO));
			transacoes.consultarTransacaoAssociada(
					prop.getProperty(PropKeys.PROP_TRANSACAO_CONSULTA_SERVICOSELECIONADO_TRANSACAO_ASSOC));
			Properties propTransacoes = propriedade.loadProperties("configuracaoPrint.properties");
			transacoes
					.print(propTransacoes.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CONSULTA_RESULTADO_CONSULTA_7));
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.transacoes.getDriver().close();
	}
}
