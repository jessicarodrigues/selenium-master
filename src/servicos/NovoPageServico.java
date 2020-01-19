package servicos;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import relatorioAdesao.RelatorioAdesaoPages;

public class NovoPageServico {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoPageServico(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pesquisaServicos(String categoria, String servicos){
		
		try {
			Select cbCategoria = new Select(driver.findElement(By.name("categoriaServico")));
			cbCategoria.selectByVisibleText(categoria);
			Thread.sleep(2000);
			WebElement buttonPesquisa = driver.findElement(By.id("btnListarServico"));
			buttonPesquisa.click();
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_PREENCHE_CAMPOS_4));
			Select cbServicos = new Select(driver.findElement(By.name("codigoServico")));
			cbServicos.selectByValue(servicos);
			Thread.sleep(2000);
			WebElement buttonConsultar = driver.findElement(By.id("btnConsultarServico"));
			buttonConsultar.click();
			Thread.sleep(2000);
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_SERVICOS_ALTERACAO_RESULTADO_PESQUISA_5));
			Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void printTela(String nome){
		new ServicosPages(driver).print(nome);
	}
	

}
