package relatoriosTransacoesRejeitadas;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import adesao.PropKeys;
import propertiesArquivo.ArquivoPropertie;
import relatorioAdesao.RelatorioAdesaoPages;

public class NovoRelatorioTransacaoRejeitadaPage {
	
	private final WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();

	public NovoRelatorioTransacaoRejeitadaPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String tipoRelatorio, String tipoServico, String categorizacao, String canal, String motivoRejeicao){
		
		try {
			Select cbTipoRelatorio = new Select(driver.findElement(By.name("tipoRelatorio")));
			cbTipoRelatorio.selectByValue(tipoRelatorio);
			Thread.sleep(2000);
			Select cbTipoServico = new Select(driver.findElement(By.name("tipoServico")));
			cbTipoServico.selectByValue(tipoServico);
			Thread.sleep(2000);
			Select cbCategoria = new Select(driver.findElement(By.name("categoria")));
			cbCategoria.selectByValue(categorizacao);
			Thread.sleep(2000);
			Select cbCanal = new Select(driver.findElement(By.name("canalSelecionado")));
			cbCanal.selectByValue(canal);
			Thread.sleep(2000);
			Select cbMotivoRejeicao = new Select(driver.findElement(By.name("motivoRejeicao")));
			cbMotivoRejeicao.selectByVisibleText(motivoRejeicao);
			 Thread.sleep(2000);
			 Properties propScreenshot = propriedade.loadProperties("configuracaoPrint.properties");
			 printTela(propScreenshot.getProperty(PropKeys.PROP_PRINT_SCREEN_REL_TRANSACOES_REJEITADA_PREENCHE_CAMPOS_4));
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
		new RelatorioTransacoesRejeitadasPages(driver).print(nome);
	}
}
