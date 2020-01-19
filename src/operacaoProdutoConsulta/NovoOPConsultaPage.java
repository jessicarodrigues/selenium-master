package operacaoProdutoConsulta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NovoOPConsultaPage {

	private final WebDriver driver;
	
	public NovoOPConsultaPage(WebDriver driver){
		this.driver = driver;
	}
	
	//@SuppressWarnings("deprecation")
	public void consultaOPeracaoProduto(String tipoConta, Integer operacaoProduto) throws Exception{
		
//		boolean temOperacaoProduto = new WebDriverWait(driver, 10).
//				until(ExpectedConditions.textToBePresentInElement(By.id("produtoVO.codigo"), operacaoProduto));
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("produtoVO.tipoConta")));
		
		Select cbTipoConta = new Select(driver.findElement(By.name("produtoVO.tipoConta")));
		cbTipoConta.selectByVisibleText(tipoConta);
		Thread.sleep(3000);
		
		Select cbOperacaoProduto = new Select(driver.findElement(By.name("produtoVO.codigo")));
		cbOperacaoProduto.selectByVisibleText(String.valueOf(operacaoProduto));
			
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.textToBePresentInElement(By.id("operacaoProduto"), String.valueOf(operacaoProduto)));
		
		WebElement buttonConsultarOP = driver.findElement(By.id("btnConsultarOperacaoProduto"));
		buttonConsultarOP.click(); 
				
	}
}
