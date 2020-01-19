package operacaoProduto;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class TesteOPCadastraPrincipal {

	ArquivoPropertie propriedade = new ArquivoPropertie();
	private WebDriver driver;
	private OperacaoProdutoPages operacoes;

	public static void main(String[] args) throws Exception {

		TesteOPCadastraPrincipal app = new TesteOPCadastraPrincipal();

		try {
			app.abreNavegador();
			app.logarTesteOperacaoProduto();

		} finally {
			app.closeWebDriver();
		}
	}

	public void abreNavegador() {

		operacoes = new OperacaoProdutoPages(driver);
	}

	public int gerarCodigo() {

		Random gerador = new Random();

		int numero = gerador.nextInt(101);

		System.out.println(numero);
		return numero;
	}

	public void logarTesteOperacaoProduto() {

		try {
			Properties prop = propriedade.getPopOperacaoProduto();
			operacoes.visita();
			operacoes.novo().preenche(prop.getProperty(PropKeys.PROP_OPERACAO_PRODUTO_TIPO_CONTA), gerarCodigo(),
					prop.getProperty(PropKeys.PROP_OPERACAO_PRODUTO_TIPO_DOCUMENTO),
					prop.getProperty(PropKeys.PROP_OPERACAO_PRODUTO_SERVICOS));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeWebDriver() {
		this.operacoes.getDriver().close();
	}
}
