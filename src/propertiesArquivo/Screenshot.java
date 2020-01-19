package propertiesArquivo;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import adesao.PropKeys;


public class Screenshot {
	
	public WebDriver driver;
	ArquivoPropertie propriedade = new ArquivoPropertie();
	
	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public String captureScreen(String diretorio, String nomeArquivo) {
	    String path;
	    try {
	    	//Properties propPath = propriedade.loadProperties("configuracaoPrint.properties");

	        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        path = diretorio+nomeArquivo + ".jpg";
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    
	    return path;
	}
	
	}
