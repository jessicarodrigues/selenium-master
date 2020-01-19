package consultaMsgsEnviadas;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import canal.CanalPages;
import propertiesArquivo.ArquivoPropertie;

public class NovoConsultaMsgsEnviadasPage {
	
	public WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoConsultaMsgsEnviadasPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String formaConsulta, String cpfCnpjNis, String ddd, String numTelefone, String tipoServico, String subServico){
		
		try {
			Select cbFormaConsulta = new Select(driver.findElement(By.name("tipoConsulta")));
			cbFormaConsulta.selectByValue(formaConsulta);
			Thread.sleep(1000);
			WebElement inputCpfCnpjNis = driver.findElement(By.id("numeroIdentificacaoCliente"));
			inputCpfCnpjNis.sendKeys(cpfCnpjNis);
			Thread.sleep(1000);
			WebElement inputDDD = driver.findElement(By.name("ddd"));
			inputDDD.sendKeys(ddd);
			Thread.sleep(1000);
			WebElement inputNumTelefone = driver.findElement(By.name("numeroTelefone"));
			inputNumTelefone.sendKeys(numTelefone);
			Thread.sleep(1000);
			Select cbTipoServico = new Select (driver.findElement(By.name("tipoDeServico")));
			cbTipoServico.selectByValue(tipoServico);
			Thread.sleep(1000);
			Select cbSubServico = new Select(driver.findElement(By.id("subservico")));
			cbSubServico.selectByValue(subServico);
			Thread.sleep(1000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_MSGS_ENVIADAS_PREENCHE_CAMPOS_4));
			Thread.sleep(1000);
			 WebElement buttonPDF = driver.findElement(By.id("PDF"));
		        buttonPDF.click();
		        Thread.sleep(2000);
		        printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_MSGS_ENVIADAS_DOWNLOAD_5));
		        WebElement buttonXLS = driver.findElement(By.id("XLS"));
		        buttonXLS.click();
		        Thread.sleep(2000);
		        WebElement buttonCSV = driver.findElement(By.id("HTML"));
		        buttonCSV.click();
		        Thread.sleep(2000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void printTela(String nome){
		new ConsultaMensagensEnviadasPages(driver).print(nome);
	}
	
}
