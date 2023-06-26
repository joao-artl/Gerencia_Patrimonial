package visao;

import javax.swing.*;

import controle.ControleEmpresa;

import java.awt.*;
import java.awt.event.*;

public class TelaPrincipal implements ActionListener {
	private static JFrame janelaInicial = new JFrame("Gerência Patrimonial");
	private static JButton filial = new JButton("Listar Filiais");
	private static JButton empresa = new JButton("Listar Patrimônios");
	private static JButton lupa = new JButton("buscar"); 
	private static JLabel textoBusca = new JLabel("buscar patrimônio"); 
	private static JTextField busca = new JTextField();
	private static Color cinzinha = new Color(230, 230, 230);
	private static ControleEmpresa dadosEmpresa = new ControleEmpresa();
	
	public TelaPrincipal() {
		janelaInicial.setLayout(null);
		janelaInicial.setBounds(515, 190, 500, 300);
		
		filial.setBounds(20, 220, 105, 30);
		empresa.setBounds(320, 220, 137, 30);
		busca.setBounds(80, 40, 250, 30);
		lupa.setBounds(335, 41, 70, 25);
		textoBusca.setBounds(80, 20, 150, 20);
		textoBusca.setFont(new Font("Arial", Font.PLAIN, 14));
		lupa.setFont(new Font("Arial", Font.BOLD, 10));
		
		filial.setBackground(cinzinha);
		empresa.setBackground(cinzinha);
		lupa.setBackground(new Color(255,255,255));
		
		janelaInicial.add(filial);
		janelaInicial.add(empresa);
		janelaInicial.add(lupa);
		janelaInicial.add(busca);
		janelaInicial.add(textoBusca);
		
		janelaInicial.setVisible(true);
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TelaPrincipal inicio = new TelaPrincipal();
		
		filial.addActionListener(inicio);
		empresa.addActionListener(inicio);
		lupa.addActionListener(inicio);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == filial) {
			new TelaFilial(dadosEmpresa);
		}
		
		else if(event.getSource() == empresa) {
			new TelaListaPatrimonios(dadosEmpresa);
		}
		
		else if(event.getSource() == lupa) {
			String itemPesquisado = busca.getText();
			int[] posicoes = dadosEmpresa.procurarPatrimonio(itemPesquisado);
			
			//if(posicoes != null)
				new TelaCadastro().inserirEditar(posicoes[0], posicoes[1], dadosEmpresa, posicoes[2], false);
			
				/*
			else 
				mensagemErro();
				 */
		}
	}
	
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "Patrimonio não cadastrado\n ", null, JOptionPane.ERROR_MESSAGE);
	}
}
