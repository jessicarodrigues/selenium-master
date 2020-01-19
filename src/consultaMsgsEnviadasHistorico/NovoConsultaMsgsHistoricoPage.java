package consultaMsgsEnviadasHistorico;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import consultaMsgsEnviadas.ConsultaMensagensEnviadasPages;
import propertiesArquivo.ArquivoPropertie;

public class NovoConsultaMsgsHistoricoPage {
	
	ArquivoPropertie propriedade = new ArquivoPropertie();
	public WebDriver driver;

	public NovoConsultaMsgsHistoricoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String formaConsulta, String dataIni, String dataFim, String agencia, String conta,String operacaoProduto, String cpfCNPJ, 
			String ddd, String numeroTelefone, String tipoServico, String subServico){
		
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

			Select cbFormConsulta = new Select(driver.findElement(By.name("tipoConsultaHistorico")));
			cbFormConsulta.selectByVisibleText(formaConsulta);
			Thread.sleep(2000);
			
			WebElement inputDtInicial = driver.findElement(By.id("datetimepickerIni"));
			js.executeScript("$('#datetimepickerIni').val('"+dataIni+"')",inputDtInicial);
			Thread.sleep(2000);
			
			WebElement inputDtFinal = driver.findElement(By.id("datetimepickerFim"));
			js.executeScript("$('#datetimepickerFim').val('"+dataFim+"')",inputDtFinal);
			Thread.sleep(2000);
			
			WebElement inputAgencia = driver.findElement(By.name("agencia"));
			inputAgencia.sendKeys(agencia);
			Thread.sleep(2000);
			WebElement inputConta = driver.findElement(By.name("conta"));
			inputConta.sendKeys(conta);
			Thread.sleep(2000);

			WebElement inputcbCpfCnpj = driver.findElement(By.id("cpfCnpj"));
			inputcbCpfCnpj.sendKeys(cpfCNPJ);
			
			Thread.sleep(2000);
			WebElement inputDDD = driver.findElement(By.name("ddd"));
			inputDDD.sendKeys(ddd);
			Thread.sleep(2000);
			WebElement inputNumTelefone = driver.findElement(By.name("numeroTelefone"));
			inputNumTelefone.sendKeys(numeroTelefone);
			Thread.sleep(2000);
			Select cbTipoServico = new Select(driver.findElement(By.name("tipoDeServico")));
			cbTipoServico.selectByValue(tipoServico);
			Thread.sleep(2000);
			Select cbSubServico = new Select(driver.findElement(By.name("subservico")));
			cbSubServico.selectByValue(subServico);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_MSGS_ENVIADAS_HISTORICO_PREENCHE_CAMPOS_4));
			Thread.sleep(2000);
			WebElement buttonPDF = driver.findElement(By.id("PDF"));
			buttonPDF.click();
			Thread.sleep(1000);
			WebElement buttonXLS = driver.findElement(By.id("XLS"));
			buttonXLS.click();
			Thread.sleep(1000);
			WebElement buttonHTML = driver.findElement(By.id("HTML"));
			buttonHTML.click();
			Thread.sleep(3000);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void printTela(String nome){
		new ConsultaMensagensEnviadasPages(driver).print(nome);
	}
}
