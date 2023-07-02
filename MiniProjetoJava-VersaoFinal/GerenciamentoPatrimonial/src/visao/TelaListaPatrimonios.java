package visao;

/**
 * Classe que e responsavel por listar os patrimonios
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since  2023
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;

public class TelaListaPatrimonios implements ActionListener {
	private JFrame janelaLista = new JFrame("Patrimônios da Empresa");
	private JLabel textoLista = new JLabel("Patrimônios da Empresa");
	private JButton atualizar = new JButton("Atualizar");
	private JList<String> patrimonios;
	private ControleEmpresa dados;
	private JScrollPane barraRolagem;

	/**
	 * Construtor da TelaListaPatrimonios
	 * 
	 * @param dadosEmpresa
	 */
	public TelaListaPatrimonios(ControleEmpresa dadosEmpresa) {
		this.dados = dadosEmpresa;
		patrimonios = new JList<String>(dados.getDados().listarTodosPatrimonios());
		barraRolagem = new JScrollPane(patrimonios);

		janelaLista.setLayout(null);
		janelaLista.setBounds(515, 505, 500, 300);
		janelaLista.getContentPane().setBackground(new Color(242, 236, 236));

		barraRolagem.setBounds(90, 45, 300, 150);
		atualizar.setBounds(160, 220, 150, 30);
		textoLista.setBounds(150, 5, 200, 30);
		textoLista.setFont(new Font("Arial", Font.BOLD, 16));

		atualizar.setBackground(new Color(255, 255, 255));

		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		janelaLista.add(textoLista);
		janelaLista.add(barraRolagem);
		janelaLista.add(atualizar);
		janelaLista.setVisible(true);

		atualizar.addActionListener(this);
	}

	/**
	 * Eventos relacionados ao JList
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == atualizar) {
			patrimonios.setListData(dados.getDados().listarTodosPatrimonios());
			patrimonios.updateUI();
		}
	}
}
