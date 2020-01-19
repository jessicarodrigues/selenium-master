package tela;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import org.openqa.selenium.WebDriver;

import adesao.Adesao;
import adesao.ProcessaDadosDeEntrada;
import canal.CanalPages;
import canal.TesteMenuCanal2_teste;
import canalAltera.TesteCanalAlteraPrincipal;
import canalConsulta.TesteMenuCanalPrincipal;
import canalExclusao.TesteCanalExcluiPrincipal;
import operacaoProduto.TesteOPCadastraPrincipal;
import parametros.TesteParametrosAlteraPrincipal;


public class Tela extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private WebDriver driver;
	
	Botao botoes = new Botao();
	ProcessaDadosDeEntrada dados = new ProcessaDadosDeEntrada();
	Adesao adesao = new Adesao();
	TesteMenuCanal2_teste canalInclusao = new TesteMenuCanal2_teste();
	TesteMenuCanalPrincipal canalConsulta =  new TesteMenuCanalPrincipal();
	TesteCanalAlteraPrincipal canalAltera = new TesteCanalAlteraPrincipal();
	TesteCanalExcluiPrincipal canalExclui = new TesteCanalExcluiPrincipal();
	TesteParametrosAlteraPrincipal parametros = new TesteParametrosAlteraPrincipal();
	TesteOPCadastraPrincipal opProduto = new TesteOPCadastraPrincipal();
	
	public int gerarCodigo() {
		Random gerador = new Random();
		 
	    int numero = gerador.nextInt(501);
	 
	     System.out.println(numero);
		return numero;
}
	
	public void criaTela() {

		// Tela
		setTitle("AUTOMAÇÃO REMODELAGEM");
		setSize(700, 500);
		setLocation(450, 100);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("SELECIONE UM FLUXO PARA TESTE");
		l1.setBounds(20,10,350,30);
		l1.setForeground(Color.WHITE);
		
		getContentPane().add(l1);
	}

	public void criaBotoes() {
		botoes.definirBotoesTelaPrincipal(this, this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("command_sair")){
			System.exit(0);
			
		} else{
		
		String itemSelecionado = botoes.pegarSelected();
		
		switch (itemSelecionado) {		
			
		case "Adesão":
			adesao.abreBrowser();
			adesao.login();
			dados.adesaoInclusaoSidecOP001PFComSucesso();
			adesao.inclusao();
			dados.adesaoConsultaSidecOP001PFComSucesso();
			adesao.consulta();
			dados.adesaoAlteracaoSidecOP001PFComSucesso();
			adesao.alteracao();
			dados.adesaoExclusaoSidecOP001PFComSucesso();
			adesao.exclusao();
			adesao.fechaBrowser();
			break;
			
		case "Canal - Inclusão":
			canalInclusao.abreNavegador();
			canalInclusao.logarSigmsTesteCanal();
			canalInclusao.closeWebDriver();
			break;
			
		case "Canal - Consulta":
			canalConsulta.abreNavegador();
			canalConsulta.deveConsultar();
			canalConsulta.closeWebDriver();
			break;
			
		case "Canal - Altera":
			canalAltera.abreNavegador();
			canalAltera.deveAlterar();
			canalAltera.closeWebDriver();
			break;
			
		case "Canal - Exclusão":
			canalExclui.abreNavegador();
			canalExclui.deveExcluir();
			canalExclui.closeWebDriver();
			break;
			
		case "Parâmetros":
			parametros.abreNavegador();
			parametros.deveAlterar();
			parametros.closeWebDriver();
			break;
			
		case "Operação Produto - Inclusão":
			opProduto.abreNavegador();
			opProduto.logarTesteOperacaoProduto();
			opProduto.closeWebDriver();
			break;
	 }
	}
  }
}
