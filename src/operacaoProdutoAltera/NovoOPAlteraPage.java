package operacaoProdutoAltera;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import canal.CanalPages;
import propertiesArquivo.ArquivoPropertie;

public class NovoOPAlteraPage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoOPAlteraPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void altera(String tipoConta, String operacaoProduto){
		
		try {
			Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
			cbTipoConta.selectByVisibleText(tipoConta);
			Thread.sleep(2000);
			Select cbOperacaoProduto = new Select(driver.findElement(By.name("produtoVO.codigo")));
			cbOperacaoProduto.selectByValue(operacaoProduto);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_PREENCHE_CAMPOS_4));
			Thread.sleep(1000);
			WebElement buttonAteraOP = driver.findElement(By.id("btnAlterarOperacaoProduto"));
			buttonAteraOP.click();
			Thread.sleep(1000);
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_ALTERA_TELA_ALTERACAO_5));
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printTela(String nome){
		new OperacaoProdutoAlteraPages(driver).print(nome);
	}
}
