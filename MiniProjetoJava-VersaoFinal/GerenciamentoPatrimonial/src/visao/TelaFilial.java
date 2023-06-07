package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TelaFilial implements ActionListener {
	private JFrame janelaFiliais = new JFrame("Filiais");
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton atualizar = new JButton("Atualizar");
	private JLabel textoFiliais = new JLabel("Filiais");
	//private JList<String> filiais;
	private static Color cinzinha = new Color(230, 230, 230);
	
	public TelaFilial() {
		janelaFiliais.setLayout(null);
		janelaFiliais.setBounds(10, 100, 500, 300);
		
		cadastrar.setBounds(30, 210, 100, 30);
		atualizar.setBounds(340, 210, 100, 30);
		textoFiliais.setBounds(215, 5, 100, 30);
		textoFiliais.setFont(new Font("Arial", Font.BOLD, 14));
		
		cadastrar.setBackground(cinzinha);
		atualizar.setBackground(cinzinha);
		
		janelaFiliais.add(cadastrar);
		janelaFiliais.add(atualizar);
		janelaFiliais.add(textoFiliais);
		
		janelaFiliais.setVisible(true);
		
		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);
	}	
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == cadastrar) {
			new TelaCadastroFilial();
		}
		
		else if(event.getSource() == atualizar) {
			
		}
	}
}