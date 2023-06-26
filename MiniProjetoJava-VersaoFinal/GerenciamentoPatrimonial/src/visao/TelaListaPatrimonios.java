package visao;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;

public class TelaListaPatrimonios implements ActionListener {
	private JFrame janelaLista = new JFrame("Patrimônios da Empresa");
	private JLabel textoLista = new JLabel("Patrimônios da Empresa");
	private JButton atualizar = new JButton("Atualizar");
	private JList<String> patrimonios;
	private ControleEmpresa dadosEmpresa;
	private JScrollPane barraRolagem;
	
	public TelaListaPatrimonios(ControleEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
		patrimonios = new JList<String>(dadosEmpresa.getDados().listarTodosPatrimonios());
		barraRolagem = new JScrollPane(patrimonios);
		
		janelaLista.setLayout(null);
		janelaLista.setBounds(515, 505, 500, 300);
		barraRolagem.setBounds(30, 50, 300, 120);
		atualizar.setBounds(360, 220, 100, 30);
		textoLista.setBounds(155, 5, 175, 30);
		textoLista.setFont(new Font("Arial", Font.BOLD, 14));
		
		//patrimonios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patrimonios.setVisibleRowCount(10);
		
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		atualizar.addActionListener(this);
		
		janelaLista.add(textoLista);
		//janelaLista.add(patrimonios);
		janelaLista.add(barraRolagem);
		janelaLista.add(atualizar);
		janelaLista.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == atualizar) {
			patrimonios.setListData(dadosEmpresa.getDados().listarTodosPatrimonios());			
			patrimonios.updateUI();
		}
	}

	public void valueChanged(ListSelectionEvent event) {
		if(event.getValueIsAdjusting() && event.getSource() == patrimonios) {
		}
	}
}
