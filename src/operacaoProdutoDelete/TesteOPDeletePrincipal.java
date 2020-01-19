package operacaoProdutoDelete;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteOPDeletePrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private OperacaoProdutoDeletePages operacaoProduto;

	public static void main(String[] args) throws Exception {
		TesteOPDeletePrincipal app = new TesteOPDeletePrincipal();

		try {
			app.abreNavegador();
			app.deveExluir();
		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {
		this.operacaoProduto = new OperacaoProdutoDeletePages(driver);
	}

	public void deveExluir() {

		try {
			Properties prop = propriedade.loadProperties("operacaoProduto.properties");

			operacaoProduto.visita();
			operacaoProduto.novo().delete(prop.getProperty(PropKeys.PROP_OP_PRODUTO_DELETE_TIPO_CONTA),
					prop.getProperty(PropKeys.PROP_OP_PRODUTO_DELETE_OPERACAO_PRODUTO));
			operacaoProduto.resultadoExclusao("", "", "", "", "");
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			operacaoProduto.print(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_MSG_FEEDBACK_7));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.operacaoProduto.getDriver().close();
	}
}
