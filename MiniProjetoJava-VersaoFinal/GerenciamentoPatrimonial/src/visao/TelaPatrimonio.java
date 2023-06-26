package visao;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;
import modelo.Imobiliario;
import modelo.ItemDePatrimonio;
import modelo.Utilitario;
import modelo.Veiculo;

public class TelaPatrimonio implements ActionListener ,ListSelectionListener {
	private JFrame janelaPatrimonios = new JFrame("Patrimônios");
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton atualizar = new JButton("Atualizar");
	private JLabel textoPatrimonio = new JLabel("Patrimônios");
	private Color cinzinha = new Color(230, 230, 230);
	private JList<String> patrimonios;
	private JScrollPane barraRolagem;
	private ControleEmpresa dados;
	private int fSelecionada;
	
	public TelaPatrimonio(ControleEmpresa c, int index) {
		fSelecionada = index;
		dados = c;
		patrimonios = new JList<String>(dados.getFilial(fSelecionada).getNomesPatrimonios());
		barraRolagem = new JScrollPane(patrimonios);
		
		janelaPatrimonios.setLayout(null);
		janelaPatrimonios.setBounds(1025, 100, 500, 300);
	
		cadastrar.setBounds(20, 220, 100, 30);
		atualizar.setBounds(360, 220, 100, 30);
		barraRolagem.setBounds(30, 50, 300, 120);
		textoPatrimonio.setBounds(215, 5, 100, 30);
		textoPatrimonio.setFont(new Font("Arial", Font.BOLD, 14));
		
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		cadastrar.setBackground(cinzinha);
		atualizar.setBackground(cinzinha);
		
		janelaPatrimonios.add(cadastrar);
		janelaPatrimonios.add(atualizar);
		janelaPatrimonios.add(textoPatrimonio);
		janelaPatrimonios.add(barraRolagem);
		
		janelaPatrimonios.setVisible(true);
		
		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);
		
		patrimonios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patrimonios.setVisibleRowCount(10);
		patrimonios.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == cadastrar) {
			new TelaCadastro().inserirEditar(fSelecionada, dados.getFilial(fSelecionada).getPatrimonios().size(), dados, 1, true);
		}
		
		else if(event.getSource() == atualizar) {
			patrimonios.setListData(dados.getFilial(fSelecionada).getNomesPatrimonios());
		}
	}
	
	public void valueChanged(ListSelectionEvent event) {
		if(event.getValueIsAdjusting() && event.getSource() == patrimonios) {
			ItemDePatrimonio select = dados.getFilial(fSelecionada).getPatrimonios().get(patrimonios.getSelectedIndex());
			
			int op = 0;
			if(select instanceof Imobiliario) op = 1;
			else if(select instanceof Utilitario) op = 2;
			else if(select instanceof Veiculo) op = 3;
			
			new TelaCadastro().inserirEditar(fSelecionada, patrimonios.getSelectedIndex(), dados, op, false);
		}
	}
}
