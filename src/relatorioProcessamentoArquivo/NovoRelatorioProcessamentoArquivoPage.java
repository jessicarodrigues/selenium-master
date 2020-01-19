package relatorioProcessamentoArquivo;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import relatorioAdesao.RelatorioAdesaoPages;

public class NovoRelatorioProcessamentoArquivoPage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoRelatorioProcessamentoArquivoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String statusArquivo, String tipoArquivo, String dtInicio, String dtFinal){
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Select cbStatusArquivio = new Select(driver.findElement(By.name("statusArquivo")));
			cbStatusArquivio.selectByValue(statusArquivo);
			
			Select cbTipoArquivo = new Select(driver.findElement(By.name("tipoArquivo")));
			cbTipoArquivo.selectByValue(tipoArquivo);
			
			WebElement inputDtInicial = driver.findElement(By.id("datetimepickerIni"));
			js.executeScript("$('#datetimepickerIni').val('"+dtInicio+"')", inputDtInicial);
			Thread.sleep(2000);
			WebElement inputDtFinal = driver.findElement(By.id("datetimepickerFim"));
			js.executeScript("$('#datetimepickerFim').val('"+dtFinal+"')",inputDtFinal);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_PROCESS_ARQUIVO_PREENCHE_CAMPOS_4));
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
		new RelatorioProcessamentoArquivoPages(driver).print(nome);
	}
}
