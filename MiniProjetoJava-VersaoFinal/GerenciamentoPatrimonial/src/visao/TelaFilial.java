package visao;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InterruptedIOException;

import controle.*;

public class TelaFilial implements ActionListener ,ListSelectionListener {
	private JFrame janelaFiliais = new JFrame("Filiais");
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton atualizar = new JButton("Atualizar");
	private JLabel textoFiliais = new JLabel("Filiais");
	private Color cinzinha = new Color(230, 230, 230);
	private JList<String> filiais;
	private ControleEmpresa dadosEmpresa;
	
	public TelaFilial() {
		dadosEmpresa = new ControleEmpresa();
		filiais = new JList<String>(dadosEmpresa.getDados().getNomesFiliais());
		
		janelaFiliais.setLayout(null);
		janelaFiliais.setBounds(10, 100, 500, 300);
		
		cadastrar.setBounds(20, 220, 100, 30);
		atualizar.setBounds(360, 220, 100, 30);
		filiais.setBounds(30, 50, 300, 120);
		textoFiliais.setBounds(215, 5, 100, 30);
		textoFiliais.setFont(new Font("Arial", Font.BOLD, 14));
		
		cadastrar.setBackground(cinzinha);
		atualizar.setBackground(cinzinha);
		
		janelaFiliais.add(cadastrar);
		janelaFiliais.add(atualizar);
		janelaFiliais.add(textoFiliais);
		janelaFiliais.add(filiais);
		
		janelaFiliais.setVisible(true);
		
		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);
		
		filiais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		filiais.setVisibleRowCount(10);
		filiais.addListSelectionListener(this);
	}	
	
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == cadastrar) {
			new TelaCadastro(1);
		}
		
		else if(event.getSource() == atualizar) {
			
		}
	}
	
	public void valueChanged(ListSelectionEvent event) {
		if(event.getValueIsAdjusting() && event.getSource() == filiais) {
			new TelaCadastro(1).inserirEditar(filiais.getSelectedIndex(), dadosEmpresa);
		}
	}
	
}