package operacaoProduto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoInclusaoOperacaoPage {

	public WebDriver driver;

	public NovoInclusaoOperacaoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void preenche(String tipoConta, int codigo, String tipoDocumento, String servicos){
		
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			Select inputTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
			inputTipoConta.selectByVisibleText(tipoConta);
			Thread.sleep(2000);
			WebElement inputCondigo = driver.findElement(By.name("produtoVO.codigo"));
			inputCondigo.sendKeys(String.valueOf(codigo));
			Thread.sleep(2000);
			Select inputDocumento = new Select(driver.findElement(By.name("produtoVO.tipoPessoa")));
			inputDocumento.selectByVisibleText(tipoDocumento);
			Thread.sleep(2000);
			Select inputServico = new Select(driver.findElement(By.name("servicos")));
			inputServico.selectByVisibleText(servicos);
			Thread.sleep(2000);
			WebElement buttonAdicionarServico = driver.findElement(By.id("btnAdicionarServico"));
			buttonAdicionarServico.click();
			Thread.sleep(2000);
			WebElement buttonIncluir = driver.findElement(By.id("btnIncluir"));
			buttonIncluir.click();
			Thread.sleep(2000);
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"formConfiguracaoServico\"]/div/div[1]/a")).click();      	
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
