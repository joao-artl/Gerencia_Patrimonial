package visao;

import javax.swing.*;
import java.awt.*;

public class TelaCadastroFilial {
	private static JFrame janelaCadastro = new JFrame("Cadastro Filial");
	private static JButton salvar = new JButton("salvar");
	private static JButton excluir = new JButton("excluir");
	private static JButton patrimonios = new JButton("patrimônios");
	private static JLabel textoNome = new JLabel("Nome: ");
	private static JLabel textoCNPJ = new JLabel("CNPJ: ");
	private static JLabel textoEmail = new JLabel("Email: ");
	private static JLabel textoTelefone = new JLabel("Telefone: ");
	private static JLabel textoEndereco = new JLabel("Endereço: ");
	private static JTextField nome = new JTextField(), cnpj = new JTextField(),
	   email = new JTextField(), telefone = new JTextField(), endereco = new JTextField();
	public static Font arial = new Font("Arial", Font.BOLD, 14);
	private static Color cinzinha = new Color(230, 230, 230);
	
	public TelaCadastroFilial() {
		janelaCadastro.setLayout(null);
		janelaCadastro.setBounds(10, 450, 500, 300);
		
		salvar.setBounds(20, 210, 100, 30);
		patrimonios.setBounds(190, 210, 100, 30);
		excluir.setBounds(360, 210, 100, 30);
		textoNome.setBounds(40, 30, 60, 20);
		textoCNPJ.setBounds(40, 60, 60, 20);
		textoEmail.setBounds(40, 90, 60, 20);
		textoTelefone.setBounds(40, 120, 80, 20);
		textoEndereco.setBounds(40, 150, 80, 20);
		nome.setBounds(120, 30, 250, 23);
		cnpj.setBounds(120, 60, 250, 23);
		email.setBounds(120, 90, 250, 23);
		telefone.setBounds(120, 120, 250, 23);
		endereco.setBounds(120, 150, 250, 23);
		
		salvar.setBackground(cinzinha);
		patrimonios.setBackground(cinzinha);
		excluir.setBackground(cinzinha);
		
		textoNome.setFont(arial);
		textoCNPJ.setFont(arial);
		textoEmail.setFont(arial);
		textoTelefone.setFont(arial);
		textoEndereco.setFont(arial);
		
		janelaCadastro.add(salvar);
		janelaCadastro.add(patrimonios);
		janelaCadastro.add(excluir);
		janelaCadastro.add(textoNome);
		janelaCadastro.add(textoCNPJ);
		janelaCadastro.add(textoEmail);
		janelaCadastro.add(textoTelefone);
		janelaCadastro.add(textoEndereco);
		janelaCadastro.add(nome);
		janelaCadastro.add(cnpj);
		janelaCadastro.add(email);
		janelaCadastro.add(telefone);
		janelaCadastro.add(endereco);
		
		janelaCadastro.setVisible(true);
	}
}