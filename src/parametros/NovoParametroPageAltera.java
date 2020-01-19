package parametros;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoParametroPageAltera {
	
	private final WebDriver driver;
	
	public NovoParametroPageAltera(WebDriver driver){
		this.driver = driver;
	}
	
	public void altera(String intervaloTempo, String horarioDeDisp, String diasArm, String valorMin, String numTent, 
			String horarioDeDispFinal, String diasArmNoti, String diasSemanaEnvio){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement inputIntervalo = driver.findElement(By.name("intervaloTentativas"));
		inputIntervalo.clear();
		WebElement inputHorarioDisp = driver.findElement(By.name("horarioDisponibilidadeDoSistemaInicial"));
		inputHorarioDisp.clear();
		WebElement inputDiasArm = driver.findElement(By.name("diasArmazenamentoAdesoesInativas"));
		inputDiasArm.clear();
		Select cbValorMin = new Select(driver.findElement(By.name("valorMinimoSistema")));
		cbValorMin.selectByVisibleText(valorMin);
		WebElement inputNumTent = driver.findElement(By.name("numeroTentativas"));
		inputNumTent.clear();
		WebElement inputHorarioDispFinal = driver.findElement(By.name("horarioDisponibilidadeDoSistemaFinal"));
		inputHorarioDispFinal.clear();
		WebElement inputDiasArmaNotificao = driver.findElement(By.name("diasArmazenamentoNotificacoes"));
		inputDiasArmaNotificao.clear();
		Select cbDiasSemanaEnv = new Select(driver.findElement(By.name("diaSemanaEnvio")));
		cbDiasSemanaEnv.selectByVisibleText(diasSemanaEnvio);
		
		 /* novo resultado da alteracao */
		
		try {
			WebElement editIntervalo = driver.findElement(By.name("intervaloTentativas"));
			editIntervalo.sendKeys(intervaloTempo);
			Thread.sleep(1000);
			WebElement editHorarioDisp = driver.findElement(By.name("horarioDisponibilidadeDoSistemaInicial"));
			editHorarioDisp.sendKeys(horarioDeDisp);
			Thread.sleep(1000);
			WebElement editDiasArm = driver.findElement(By.name("diasArmazenamentoAdesoesInativas"));
			editDiasArm.sendKeys(diasArm);
			Thread.sleep(1000);
			WebElement editNumTent = driver.findElement(By.name("numeroTentativas"));
			editNumTent.sendKeys(numTent);
			Thread.sleep(1000);
			WebElement editHorarioDispFinal = driver.findElement(By.name("horarioDisponibilidadeDoSistemaFinal"));
			editHorarioDispFinal.sendKeys(horarioDeDispFinal);
			Thread.sleep(1000);
			WebElement editDiasArmaNotificao = driver.findElement(By.name("diasArmazenamentoNotificacoes"));
			editDiasArmaNotificao.sendKeys(diasArmNoti);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"formAtualizarParametros\"]/div[1]/div[9]/input")).click();
			js.executeScript("document.getElementById('modalConfirmarAcao').click();");
			Thread.sleep(1000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
