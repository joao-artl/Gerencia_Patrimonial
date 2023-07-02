package visao;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;

/**
 * Classe que e responsavel pelos detalhes do patrimonio
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since  2023
 * @version 1.0
 */

public class TelaPatrimonio implements ActionListener, ListSelectionListener {
	private JFrame janelaPatrimonios = new JFrame("Patrimônios");
	private JButton cadastrar = new JButton("cadastrar");
	private JButton atualizar = new JButton("atualizar");
	private JLabel textoPatrimonio = new JLabel("Patrimônios");
	private Color branco = new Color(255, 255, 255);
	private JList<String> patrimonios;
	private JScrollPane barraRolagem;
	private ControleEmpresa dados;
	private int posF;

	/**
	 * Construtor da TelaPatrimonio
	 * 
	 * @param d,     faz referencia a ControleEmpresa
	 * @param index, corresponde a indice da filial
	 */
	public TelaPatrimonio(ControleEmpresa d, int index) {
		posF = index;
		dados = d;
		patrimonios = new JList<String>(dados.getFilial(posF).getNomesPatrimonios());
		barraRolagem = new JScrollPane(patrimonios);

		janelaPatrimonios.setLayout(null);
		janelaPatrimonios.setBounds(1025, 100, 500, 300);
		janelaPatrimonios.getContentPane().setBackground(new Color(242, 236, 236));

		cadastrar.setBounds(20, 220, 100, 30);
		atualizar.setBounds(360, 220, 100, 30);
		barraRolagem.setBounds(90, 45, 300, 150);
		textoPatrimonio.setBounds(200, 5, 100, 30);
		textoPatrimonio.setFont(new Font("Arial", Font.BOLD, 16));

		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		cadastrar.setBackground(branco);
		atualizar.setBackground(branco);

		janelaPatrimonios.add(cadastrar);
		janelaPatrimonios.add(atualizar);
		janelaPatrimonios.add(textoPatrimonio);
		janelaPatrimonios.add(barraRolagem);

		janelaPatrimonios.setVisible(true);

		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);

		patrimonios.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		patrimonios.addListSelectionListener(this);
	}

	/**
	 * Eventos relacionados aos botoes
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cadastrar) {
			int t = dados.getFilial(posF).getPatrimonios().size();
			new TelaCadastro().inserirEditar(posF, t, dados, 1, true);
		}

		else if (event.getSource() == atualizar) {
			patrimonios.setListData(dados.getFilial(posF).getNomesPatrimonios());
		}
	}

	/**
	 * Eventos relacionado ao JList
	 */
	// fazer o metodo de verificacao na controle
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() && event.getSource() == patrimonios) {
			int op = dados.getControleFiliais().verificarInstancia(posF, patrimonios.getSelectedIndex());
			new TelaCadastro().inserirEditar(posF, patrimonios.getSelectedIndex(), dados, op, false);
		}
	}
}
