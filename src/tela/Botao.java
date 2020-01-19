package tela;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Botao {
	JButton bt_inclusao_adesao_sidec_pf;
	JButton bt_inclusao_adesao_sidec_pj;
	JButton bt_inclusao_adesao_sidec_nextel;
	JButton bt_inclusao_adesao_nsgd_pf;
	JButton bt_inclusao_adesao_nsgd_pj;
	JButton bt_inclusao_adesao_nsgd_nextel;
	JButton bt_sair;
	JComboBox comboBox;
	JButton btnExecutar;
	
	
	int x = 165;//Comprimento do botão

	public void definirBotoesTelaPrincipal(ActionListener tela, JFrame frame) {
		bt_sair = new JButton("Sair");
		bt_sair.setBounds(600, 430, 75, 30);
		bt_sair.addActionListener(tela);
		bt_sair.setActionCommand("command_sair");

//		bt_inclusao_adesao_sidec_pf = new JButton("Adesão SIDEC PF");
//		bt_inclusao_adesao_sidec_pf.setBounds(20, 40, x, 30);
//		bt_inclusao_adesao_sidec_pf.addActionListener(tela);
//		bt_inclusao_adesao_sidec_pf.setActionCommand("command_adesao_sidec_pf");
//		
//		bt_inclusao_adesao_sidec_pj = new JButton("Adesão SIDEC PJ");
//		bt_inclusao_adesao_sidec_pj.setBounds(20, 80, x, 30);
//		bt_inclusao_adesao_sidec_pj.addActionListener(tela);
//		bt_inclusao_adesao_sidec_pj.setActionCommand("command_adesao_sidec_pj");
//		
//		bt_inclusao_adesao_sidec_nextel = new JButton("Adesão SIDEC NEXTEL");
//		bt_inclusao_adesao_sidec_nextel.setBounds(20, 120, x, 30);
//		bt_inclusao_adesao_sidec_nextel.addActionListener(tela);
//		bt_inclusao_adesao_sidec_nextel.setActionCommand("command_adesao_sidec_nextel");
//		bt_inclusao_adesao_sidec_nextel.setEnabled(false);
//		
//		bt_inclusao_adesao_nsgd_pf = new JButton("Adesão NSGD PF");
//		bt_inclusao_adesao_nsgd_pf.setBounds(20, 160, x, 30);
//		bt_inclusao_adesao_nsgd_pf.addActionListener(tela);
//		bt_inclusao_adesao_nsgd_pf.setActionCommand("command_adesao_nsgd_pf");
//
//		bt_inclusao_adesao_nsgd_pj = new JButton("Adesão NSGD PJ");
//		bt_inclusao_adesao_nsgd_pj.setBounds(20, 200, x, 30);
//		bt_inclusao_adesao_nsgd_pj.addActionListener(tela);
//		bt_inclusao_adesao_nsgd_pj.setActionCommand("command_adesao_nsgd_pj");
//		
//		bt_inclusao_adesao_nsgd_nextel = new JButton("Adesão NSGD NEXTEL");
//		bt_inclusao_adesao_nsgd_nextel.setBounds(20, 240, x, 30);
//		bt_inclusao_adesao_nsgd_nextel.addActionListener(tela);
//		bt_inclusao_adesao_nsgd_nextel.setActionCommand("command_adesao_nsgd_nextel");
//		bt_inclusao_adesao_nsgd_nextel.setEnabled(false);
//		
		
		comboBox = new JComboBox();
		comboBox.setBounds(20, 150, 250, 20);
		
		comboBox.addItem("Parâmetros");
		comboBox.addItem("Adesão");
		comboBox.addItem("Serviços");
		comboBox.addItem("Canal - Inclusão");
		comboBox.addItem("Canal - Consulta");
		comboBox.addItem("Canal - Altera");
		comboBox.addItem("Canal - Exclusão");
		comboBox.addItem("Operação Produto - Inclusão");
		comboBox.addItem("Relatórios");
		
		
		btnExecutar = new JButton("Executar");
		btnExecutar.setBounds(300, 150, 100, 20);
		btnExecutar.addActionListener(tela);
		btnExecutar.setActionCommand("command_adesao_sidec_executar");
		
		
		//frame.add(bt_sair);
//		frame.add(bt_inclusao_adesao_sidec_pf);
//		frame.add(bt_inclusao_adesao_sidec_pj);
//		frame.add(bt_inclusao_adesao_sidec_nextel);
//		frame.add(bt_inclusao_adesao_nsgd_pf);
//		frame.add(bt_inclusao_adesao_nsgd_pj);
//		frame.add(bt_inclusao_adesao_nsgd_nextel);
		frame.add(comboBox);
		frame.add(btnExecutar);
		frame.add(bt_sair);
	}
	
	public String pegarSelected(){
		return comboBox.getSelectedItem().toString();
	}
	

}
