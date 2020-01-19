package transacaoAlteracao;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteTransacaoAlteracaoPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private ConsultaTransacoesAlteracaoPages transacoesAlteracao;

	public static void main(String[] args) {

		TesteTransacaoAlteracaoPrincipal app = new TesteTransacaoAlteracaoPrincipal();

		try {
			app.abreNavegador();
			app.deveAlterarTransacao();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.transacoesAlteracao = new ConsultaTransacoesAlteracaoPages(driver);
	}

	public void deveAlterarTransacao() {
		try {
			Properties prop = propriedade.loadProperties("transacao.properties");
			transacoesAlteracao.visita();
			transacoesAlteracao.novo().consultaAlteracaoTransacao(prop.getProperty(PropKeys.PROP_TRANSACAO_ALTERA_CATEGORIA),
					prop.getProperty(PropKeys.PROP_TRANSACAO_ALTERA_SERVICO));
			transacoesAlteracao.consultarSubServicoSelecionadoAltercao(
					prop.getProperty(PropKeys.PROP_TRANSACAO_ALTERA_SERVICO_SELECIONADO));
			transacoesAlteracao.cadastraNovaTransacao(
					new Integer(prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_CODIGO)),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_DESCRICAO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_TIPO_RECEBIMENTO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_TIPO_ENV_BROKER),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_TIPO_TRANSACAO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_CADASTRA_NOVA_MASCARA_MSG));
			Properties propTransacoes = propriedade.loadProperties("configuracaoPrint.properties");
			transacoesAlteracao
					.print(propTransacoes.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_CADASTRA_MSG_FEEDBACK_5));
			Thread.sleep(2000);
			transacoesAlteracao
					.consultarTransacaoAssociadaAlteraco(prop.getProperty(PropKeys.PROP_TRANSACAO_ALTERACAO_CONSULTA_ASSOC));
			transacoesAlteracao.alterarTransacao(prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOC_ALTERACAO_DESCRICAO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOC_ALTERACAO_TIPO_RECEBIMENTO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOC_ALTERACAO_TIPO_ENV_BROKER),
					prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOC_ALTERACAO_TIPO_TRANSACAO),
					prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOC_ALTERACAO_MASCARA_MSG));
			transacoesAlteracao
					.print(propTransacoes.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_ALTERACAO_MSG_FEEDBACK_10));
			Thread.sleep(2000);
			transacoesAlteracao.consultarTransacaoAssociadaAlteraco(prop.getProperty(PropKeys.PROP_TRANSACAO_ASSOCIADA_ALTERACAO));
			transacoesAlteracao.excluiTransacao();
			transacoesAlteracao
			.print(propTransacoes.getProperty(PropKeys.PROP_PRINT_SCREEN_TRANSACAO_EXCLUI_MSG_FEEDBACK_3));
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.transacoesAlteracao.getDriver().close();
	}
}
