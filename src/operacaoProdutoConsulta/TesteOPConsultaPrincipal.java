package operacaoProdutoConsulta;

import org.openqa.selenium.WebDriver;

public class TesteOPConsultaPrincipal {
	
	private WebDriver driver;
	private OperacaoProdutoConsultaPages operacaoProduto;
	
	public static void main(String[] args) throws Exception{
		
		TesteOPConsultaPrincipal app = new TesteOPConsultaPrincipal();
		
		try{
			app.abreNavegador();
			app.deveConsultar();
		}finally{
			app.finaliza();
		}
	}
	
	public void abreNavegador(){
		this.operacaoProduto = new OperacaoProdutoConsultaPages(driver);
	}
	
	public void deveConsultar() throws Exception{
		try{
			operacaoProduto.visita("C899009", "c899009", "C:\\chromedriver\\chromedriver.exe");
			operacaoProduto.novo().consultaOPeracaoProduto("SIDEC", Integer.valueOf("222"));
			operacaoProduto.resultadoConsultaOP(222, "SIDEC", "CPF", "", "");
			
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	public void finaliza(){
		driver.close();
}

}
