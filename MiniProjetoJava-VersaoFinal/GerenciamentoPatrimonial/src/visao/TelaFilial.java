package visao;

/**
 * Classe que e responsavel pelas informacoes da filial
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since  2023
 * @version 1.0
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;

public class TelaFilial implements ActionListener, ListSelectionListener {
	private JFrame janelaFiliais = new JFrame("Filiais");
	private JButton cadastrar = new JButton("cadastrar");
	private JButton atualizar = new JButton("atualizar");
	private JLabel textoFiliais = new JLabel("Filiais");
	private Color branco = new Color(255, 255, 255);
	private JList<String> filiais;
	private ControleEmpresa dadosEmpresa;
	private JScrollPane barraRolagem;

	/**
	 * Construtror da Tela Filial
	 * 
	 * @param dadosEmpresa, faz referencia ao ControleEmpresa
	 */
	public TelaFilial(ControleEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
		filiais = new JList<String>(dadosEmpresa.getDados().getNomesFiliais());
		barraRolagem = new JScrollPane(filiais);

		janelaFiliais.getContentPane().setBackground(new Color(242, 236, 236));
		janelaFiliais.setLayout(null);
		janelaFiliais.setBounds(10, 100, 500, 300);

		cadastrar.setBounds(20, 220, 100, 30);
		atualizar.setBounds(360, 220, 100, 30);
		barraRolagem.setBounds(90, 45, 300, 150);
		textoFiliais.setBounds(220, 5, 100, 30);
		textoFiliais.setFont(new Font("Arial", Font.BOLD, 16));

		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		cadastrar.setBackground(branco);
		atualizar.setBackground(branco);

		janelaFiliais.add(cadastrar);
		janelaFiliais.add(atualizar);
		janelaFiliais.add(textoFiliais);
		janelaFiliais.add(barraRolagem);

		janelaFiliais.setVisible(true);

		cadastrar.addActionListener(this);
		atualizar.addActionListener(this);

		filiais.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		filiais.addListSelectionListener(this);
	}

	/**
	 * Evento relacionado ao botoes
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == cadastrar) {
			new TelaCadastro().inserirEditar(dadosEmpresa.getDados().getFiliais().size(), dadosEmpresa, true);
		}

		else if (event.getSource() == atualizar) {
			filiais.setListData(dadosEmpresa.getDados().getNomesFiliais());
			filiais.updateUI();
		}
	}

	/**
	 * Eventos relacionados ao JList
	 */
	public void valueChanged(ListSelectionEvent event) {
		if (event.getValueIsAdjusting() && event.getSource() == filiais) {
			new TelaCadastro().inserirEditar(filiais.getSelectedIndex(), dadosEmpresa, false);
		}
	}

}