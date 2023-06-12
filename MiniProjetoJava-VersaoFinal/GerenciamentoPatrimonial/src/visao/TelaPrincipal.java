package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal implements ActionListener {
	private static JFrame janelaInicial = new JFrame("Gerência Patrimonial");
	private static JButton filial = new JButton("Listar Filiais");
	private static JButton empresa = new JButton("Listar Patrimônios");
	private static JLabel textoBusca = new JLabel("buscar patrimônio"); 
	private static JTextField busca = new JTextField();
	private static Color cinzinha = new Color(230, 230, 230);
	
	public TelaPrincipal() {
		janelaInicial.setLayout(null);
		janelaInicial.setBounds(515, 190, 500, 300);
		
		filial.setBounds(20, 220, 105, 30);
		empresa.setBounds(320, 220, 137, 30);
		busca.setBounds(65, 40, 350, 30);
		textoBusca.setBounds(65, 20, 150, 20);
		textoBusca.setFont(new Font("Arial", Font.PLAIN, 14));
		
		filial.setBackground(cinzinha);
		empresa.setBackground(cinzinha);
		
		janelaInicial.add(filial);
		janelaInicial.add(empresa);
		janelaInicial.add(busca);
		janelaInicial.add(textoBusca);
		
		janelaInicial.setVisible(true);
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TelaPrincipal inicio = new TelaPrincipal();
		
		filial.addActionListener(inicio);
		empresa.addActionListener(inicio);
		busca.addActionListener(inicio);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == filial) {
			new TelaFilial();
		}
		
		if(event.getSource() == empresa) {
			new TelaListaPatrimonios();
		}
		
		/*
		else if(busca) {
			//mostrar resultados para a busca na mesma tela
		}
		*/
	}
}
