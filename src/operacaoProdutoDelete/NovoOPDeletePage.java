package operacaoProdutoDelete;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import canal.CanalPages;
import propertiesArquivo.ArquivoPropertie;

public class NovoOPDeletePage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoOPDeletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void delete(String tipoConta, String operacaoProduto) throws Exception{
		
		Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
		cbTipoConta.selectByVisibleText(tipoConta);
		Thread.sleep(2000);
		Select cbOperacaoProduto = new Select(driver.findElement(By.name("produtoVO.codigo")));
		cbOperacaoProduto.selectByValue(operacaoProduto);
		Thread.sleep(2000);
		Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
		printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_PREENCHE_CAMPOS_4));
		WebElement buttonDeleteOP = driver.findElement(By.id("btnExcluirOperacaoProduto"));
		buttonDeleteOP.click();
		Thread.sleep(2000);
		printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_OPERACAO_PRODUTO_EXCLUSAO_RESULTADO_EXCLUSAO_5));
		Thread.sleep(2000);
		
	}
	
	public void printTela(String nome){
		new OperacaoProdutoDeletePages(driver).print(nome);
	}
	

}
