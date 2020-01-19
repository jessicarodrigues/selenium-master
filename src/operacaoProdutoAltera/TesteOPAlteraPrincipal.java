package operacaoProdutoAltera;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteOPAlteraPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private OperacaoProdutoAlteraPages operacaoProduto;

	public static void main(String[] args) throws Exception {
		TesteOPAlteraPrincipal app = new TesteOPAlteraPrincipal();

		try {
			app.abreNavegador();
			app.deveAlterar();
		} finally {
			app.closeWebDriver();
		}

	}

	public void abreNavegador() {
		this.operacaoProduto = new OperacaoProdutoAlteraPages(driver);
	}

	public void deveAlterar() {
		try {

			Properties prop = propriedade.loadProperties("operacaoProduto.properties");
			operacaoProduto.visita();
			operacaoProduto.novo().altera(prop.getProperty(PropKeys.PROP_OP_PRODUTO_ALTERA_TIPO_CONTA),
					prop.getProperty(PropKeys.PROP_O_PRODUTO_ALTERA_OPERACAO_PRODUTO));
			operacaoProduto.resultadoAlteraOP(
					new Integer(prop.getProperty(PropKeys.PROP_OP_PRODUTO_RESULTADO_ALTERA_CODIGO)),
					prop.getProperty(PropKeys.PROP_OP_PRODUTO_RESULTADO_ALTERA_TIPO_CONTA),
					prop.getProperty(PropKeys.PROP_OP_PRODUTO_RESULTADO_ALTERA_TIPO_DOCUMENTO),
					prop.getProperty(PropKeys.PROP_OP_PRODUTO_RESULTADO_ALTERA_SERVICOS),
					prop.getProperty(PropKeys.PROP_OP_PRODUTO_RESULTADO_ALTERA_SERVICOS_ASSOC));
			Properties propScreenshotResultadoAlteracao = propriedade.loadProperties("configuracaoPrint.properties");
			operacaoProduto.print(propScreenshotResultadoAlteracao
					.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_MSG_FEEDBACK_8));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.operacaoProduto.getDriver().close();
	}
}
