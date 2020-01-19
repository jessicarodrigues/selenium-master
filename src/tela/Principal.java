package tela;

import adesao.Adesao;

public class Principal {
		
	public static void main(String args[]){

		// Chama Tela
		Tela tela = new Tela();
		tela.criaTela();
		tela.criaBotoes();
		tela.setVisible(true);
		
	}
}
