package propertiesArquivo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArquivoPropertie {

	public Properties getPropAdesao() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/adesao.properties");
		props.load(file);

		return props;
	}

	public Properties getPropCanal() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/canal.properties");
		props.load(file);

		return props;
	}

	public Properties getPropCanalConsulta() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/canal.properties");
		props.load(file);

		return props;
	}

	public Properties getPropCanalAltera() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/canal.properties");
		props.load(file);

		return props;
	}

	public Properties getPropCanalExclusao() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/canal.properties");
		props.load(file);

		return props;
	}

	public Properties getPropParametros() throws IOException {

		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/parametros.properties");
		props.load(file);

		return props;
	}
	
	public Properties getPopOperacaoProduto() throws IOException{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/operacaoProduto.properties");
		props.load(file);

		return props;
	}

	public Properties getPropOperacaoProdutoConsulta() throws IOException{
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/operacaoProduto.properties");
		props.load(file);

		return props;
	}
}
