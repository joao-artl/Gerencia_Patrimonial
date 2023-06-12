package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPatrimonio implements ActionListener {
	private JFrame janelaPatrimonios = new JFrame("Patrimônios");
	private JButton cadastrar = new JButton("Cadastrar");
	private JButton atualizar = new JButton("Atualizar");
	private JLabel textoPatrimonio = new JLabel("Patrimônios");
	private Color cinzinha = new Color(230, 230, 230);
	//private JList<String> listaPatrimonios;
	
	public TelaPatrimonio() {
		janelaPatrimonios.setLayout(null);
		janelaPatrimonios.setBounds(1025, 100, 500, 300);
	
		cadastrar.setBounds(20, 220, 100, 30);
		atualizar.setBounds(360, 220, 100, 30);
		textoPatrimonio.setBounds(215, 5, 100, 30);
		textoPatrimonio.setFont(new Font("Arial", Font.BOLD, 14));
		
		cadastrar.setBackground(cinzinha);
		atualizar.setBackground(cinzinha);
		
		janelaPatrimonios.add(cadastrar);
		janelaPatrimonios.add(atualizar);
		janelaPatrimonios.add(textoPatrimonio);
		
		janelaPatrimonios.setVisible(true);
		
		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == cadastrar) {
			new TelaCadastro(2);
		}
		
		else if(event.getSource() == atualizar) {
			
		}
	}
}
