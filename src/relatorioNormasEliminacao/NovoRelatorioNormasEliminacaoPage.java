package relatorioNormasEliminacao;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import relatorioAdesao.RelatorioAdesaoPages;

public class NovoRelatorioNormasEliminacaoPage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();
	
	
	public NovoRelatorioNormasEliminacaoPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void preenche(String dtInicio, String dtFinal, String descricao, String situacao){
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement inputDtIninicio = driver.findElement(By.id("datetimepickerIni"));
			js.executeScript("$('#datetimepickerIni').val('"+dtInicio+"')",inputDtIninicio);
			Thread.sleep(2000);
			WebElement inputDtFinal = driver.findElement(By.id("datetimepickerFinal"));
			js.executeScript("$('#datetimepickerFinal').val('"+dtFinal+"')", inputDtFinal);
			Thread.sleep(2000);
			
			Select cbDescricao = new Select(driver.findElement(By.name("descricao")));
			cbDescricao.selectByVisibleText(descricao);
			Thread.sleep(2000);
			Select cbSituacao = new Select(driver.findElement(By.name("situacao")));
			cbSituacao.selectByVisibleText(situacao);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_NORMAS_ELI_PREENCHE_CAMPOS_4));
			Thread.sleep(2000);
			WebElement buttonPDF = driver.findElement(By.id("PDF"));
	        buttonPDF.click();
	        Thread.sleep(2000);
	        WebElement buttonXLS = driver.findElement(By.id("XLS"));
	        buttonXLS.click();
	        Thread.sleep(2000);
	        WebElement buttonHTML = driver.findElement(By.id("HTML"));
	        buttonHTML.click();
	        Thread.sleep(2000);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printTela(String nome){
		new RelatorioNormasEliminacaoPages(driver).print(nome);
	}

}
