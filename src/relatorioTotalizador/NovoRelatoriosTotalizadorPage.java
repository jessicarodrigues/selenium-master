package relatorioTotalizador;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import consultaMsgsEnviadas.ConsultaMensagensEnviadasPages;
import propertiesArquivo.ArquivoPropertie;

public class NovoRelatoriosTotalizadorPage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoRelatoriosTotalizadorPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String dtInicio, String dtFinal, String tipoMensagem, String tipoServico, String categorizacao) throws InterruptedException {
		
		try {
			
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			
			    WebElement inputDtInicial = driver.findElement(By.id("datetimepickerIni"));
				js.executeScript("$('#datetimepickerIni').val('"+dtInicio+"')",inputDtInicial)	;
				Thread.sleep(2000);
				WebElement inputDtFinal = driver.findElement(By.id("datetimepickerFim"));
				js.executeScript("$('#datetimepickerFim').val('"+dtFinal+"')",inputDtFinal);	                              
				Thread.sleep(2000);
				Select cbTipoMsg = new Select(driver.findElement(By.name("tipoMensagem")));
				cbTipoMsg.getFirstSelectedOption();
				Thread.sleep(2000);
				Select cbTipoServico = new Select(driver.findElement(By.name("tipoServico")));
				cbTipoServico.getFirstSelectedOption();
				Thread.sleep(2000);
				Select cbCategorizacao = new Select(driver.findElement(By.name("categorizacao")));
				cbCategorizacao.getFirstSelectedOption();
				Thread.sleep(2000);
				Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
				printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_TOTALIZADOR_PREENCHE_CAMPOS_4));
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
		new ConsultaMensagensEnviadasPages(driver).print(nome);
	}
}
