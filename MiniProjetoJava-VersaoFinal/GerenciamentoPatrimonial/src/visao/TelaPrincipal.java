package visao;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import controle.*;

/**
 * Classe que e responsavel pela tela principal,busca e listagem de patrimonios
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since  2023
 * @version 1.0
 */

public class TelaPrincipal implements ActionListener {
	private static JFrame janelaInicial = new JFrame("Gerência Patrimonial");
	private static JLabel dzodak = new JLabel("Dzodak");
	private static JButton filial = new JButton("listar filiais");
	private static JButton empresa = new JButton("listar patrimônios");
	private static JButton lupa = new JButton("buscar");
	private static JTextField busca = new JTextField();
	private static Color branco = new Color(255, 255, 255);
	private static ControleEmpresa dados = new ControleEmpresa();

	/**
	 * Construtor da TelaPrincipal
	 */
	public TelaPrincipal() {
		janelaInicial.setLayout(null);
		janelaInicial.setBounds(515, 190, 500, 300);
		janelaInicial.getContentPane().setBackground(new Color(242, 236, 236));

		filial.setBounds(20, 220, 105, 30);
		empresa.setBounds(320, 220, 137, 30);
		busca.setBounds(80, 95, 250, 30);
		lupa.setBounds(335, 95, 70, 25);
		dzodak.setBounds(185, 35, 100, 30);

		Border borda = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 172, 182));
		dzodak.setBorder(borda);

		dzodak.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lupa.setFont(new Font("Arial", Font.BOLD, 10));

		filial.setBackground(branco);
		empresa.setBackground(branco);
		lupa.setBackground(branco);

		janelaInicial.add(dzodak);
		janelaInicial.add(filial);
		janelaInicial.add(empresa);
		janelaInicial.add(lupa);
		janelaInicial.add(busca);

		janelaInicial.setVisible(true);
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Instancia os ActionListener para os botoes do menu
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TelaPrincipal inicio = new TelaPrincipal();

		filial.addActionListener(inicio);
		empresa.addActionListener(inicio);
		lupa.addActionListener(inicio);
	}

	/**
	 * Eventos relacionados aos botoes
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == filial) {
			new TelaFilial(dados);
		}

		else if (event.getSource() == empresa) {
			new TelaListaPatrimonios(dados);
		}

		else if (event.getSource() == lupa) {
			String itemPesquisado = busca.getText();
			int[] posicoes = dados.procurarPatrimonio(itemPesquisado);

			if (posicoes != null)
				new TelaCadastro().inserirEditar(posicoes[0], posicoes[1], dados, posicoes[2], false);

			else
				mensagemErro();
		}
	}

	/**
	 * Metodo que mostra mensagem ao nao encontrar patrimonio
	 */
	public void mensagemErro() {
		JOptionPane.showMessageDialog(null, "Patrimonio nao encontrado\n ", null, JOptionPane.ERROR_MESSAGE);
	}
}
