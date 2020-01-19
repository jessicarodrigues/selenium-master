package relatorioExclusaoAdesao;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;

public class NovoRelatorioExclusaoPage {

	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoRelatorioExclusaoPage(WebDriver driver) {
		this.driver = driver;
	}

	public void preenche(String tipoRelatorio, String tipoServico, String categorizacao, String canal, String dtInicio,
			String dtFinal, String superintendencia, String agencia) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Select cbTipoRelatorio = new Select(driver.findElement(By.name("tipoRelatorio")));
			cbTipoRelatorio.selectByValue(tipoRelatorio);
			Thread.sleep(2000);
			Select cbTipoServico = new Select(driver.findElement(By.name("tipoServico")));
			cbTipoServico.selectByValue(tipoServico);
			Thread.sleep(2000);
			Select cbCategoria = new Select(driver.findElement(By.name("categoria")));
			cbCategoria.selectByValue(categorizacao);
			Thread.sleep(2000);
			Select cbCanal = new Select(driver.findElement(By.name("canalSel")));
			cbCanal.selectByValue(canal);
			Thread.sleep(2000);
			WebElement inputDtInicial = driver.findElement(By.id("datetimepickerIni"));
			js.executeScript("$('#datetimepickerIni').val('" + dtInicio + "')", inputDtInicial);
			Thread.sleep(2000);
			WebElement inputDtFinal = driver.findElement(By.id("datetimepickerFim"));
			js.executeScript("$('#datetimepickerFim').val('" + dtFinal + "')", inputDtFinal);
			Thread.sleep(2000);
			Select cbSuperintencia = new Select(driver.findElement(By.name("superintendenciaSel")));
			cbSuperintencia.selectByVisibleText(superintendencia);
			Thread.sleep(2000);
			Select cbAgencia = new Select(driver.findElement(By.name("agenciaSel")));
			cbAgencia.selectByVisibleText(agencia);
			Thread.sleep(2000);
			Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_EXCLUSAO_ADESAO_PREENCHE_CAMPOS_4));
			Thread.sleep(2000);
			WebElement buttonPDF = driver.findElement(By.id("PDF"));
			buttonPDF.click();
			Thread.sleep(2000);
			WebElement buttonXLS = driver.findElement(By.id("XLS"));
			buttonXLS.click();
			Thread.sleep(2000);
			WebElement buttonCSV = driver.findElement(By.id("CSV"));
			buttonCSV.click();
			Thread.sleep(2000);
			WebElement buttonHTML= driver.findElement(By.id("HTML"));
			buttonHTML.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void printTela(String nome){
		new RelatorioExclusaoDeAdesaoPages(driver).print(nome);
	}
}
