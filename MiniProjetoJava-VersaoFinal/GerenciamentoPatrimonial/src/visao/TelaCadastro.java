package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controle.*;

public class TelaCadastro implements ActionListener {
	private JFrame janelaCadastro;
	private JPanel painelCadastro = new JPanel();

	private JButton salvar = new JButton("salvar");
	private JButton excluir = new JButton("excluir");
	private JButton patrimonios = new JButton("Patrimônios");
	private JButton imobiliario = new JButton("Imobiliário");
	private JButton utilitario = new JButton("Utilitário");
	private JButton veiculo = new JButton("Veículo");

	private Font arial = new Font("Arial", Font.BOLD, 14);
	private Color cinzinha = new Color(230, 230, 230);

	private JLabel textoNome = new JLabel("Nome:");
	private JLabel textoValor = new JLabel("Valor: R$");
	private JLabel textoQuantidade = new JLabel("Quantidade:");
	private JLabel textoDescricao = new JLabel("Descrição:");
	private JLabel textoFuncao = new JLabel("Função:");
	private JLabel textoCor = new JLabel("Cor:");
	private JLabel textoModelo = new JLabel("Modelo:");
	private JLabel textoFabricante = new JLabel("Fabricante:");
	private JLabel textoArea = new JLabel("Área:                     m²");
	private JLabel textoEndereco = new JLabel("Endereço:");
	private JLabel textoTipo = new JLabel("Tipo:");
	private JLabel textoCnpj = new JLabel("CNPJ:");
	private JLabel textoEmail = new JLabel("Email:");
	private JLabel textoTelefone = new JLabel("Telefone:");

	private JTextField nome, valor, quantidade, descricao, funcao, 
					   cor, modelo, fabricante, area, endereco, tipo,
					   cnpj, email, telefone;
	
	private ControleEmpresa cEmpresa;
	private int fTemporaria, pTemporaria, op;

	int telaSelecionada;

	public void inserirEditar(int pos, ControleEmpresa c, boolean novo) {
		telaSelecionada = 1;
		cEmpresa = c;
		fTemporaria = pos;

		// tela de cadastro de filial
		if (novo == true) {
			nome = new JTextField();
			cnpj = new JTextField();
			email = new JTextField();
			telefone = new JTextField();
			endereco = new JTextField();
		}

		else {
			nome = new JTextField(cEmpresa.getDados().getFiliais().get(pos).getNome());
			cnpj = new JTextField(String.valueOf(cEmpresa.getDados().getFiliais().get(pos).getCnpj()));
			email = new JTextField(cEmpresa.getDados().getFiliais().get(pos).getEmail());
			telefone = new JTextField(String.valueOf(cEmpresa.getDados().getFiliais().get(pos).getTelefone()));
			endereco = new JTextField(cEmpresa.getDados().getFiliais().get(pos).getEndereco());	
		}

		janelaCadastro = new JFrame("Cadastro Filial");
		janelaCadastro.setBounds(10, 450, 500, 300);

		textoNome.setBounds(40, 30, 60, 20);
		textoCnpj.setBounds(40, 60, 60, 20);
		textoEmail.setBounds(40, 90, 60, 20);
		textoTelefone.setBounds(40, 120, 80, 20);
		textoEndereco.setBounds(40, 150, 80, 20);
		nome.setBounds(120, 30, 250, 23);
		cnpj.setBounds(120, 60, 250, 23);
		email.setBounds(120, 90, 250, 23);
		telefone.setBounds(120, 120, 250, 23);
		endereco.setBounds(120, 150, 250, 23);
		patrimonios.setBounds(185, 220, 105, 30);

		patrimonios.setBackground(cinzinha);

		textoNome.setFont(arial);
		textoCnpj.setFont(arial);
		textoEmail.setFont(arial);
		textoTelefone.setFont(arial);
		textoEndereco.setFont(arial);

		janelaCadastro.add(patrimonios);

		janelaCadastro.add(textoNome);
		janelaCadastro.add(textoCnpj);
		janelaCadastro.add(textoEmail);
		janelaCadastro.add(textoTelefone);
		janelaCadastro.add(textoEndereco);

		janelaCadastro.add(nome);
		janelaCadastro.add(cnpj);
		janelaCadastro.add(email);
		janelaCadastro.add(telefone);
		janelaCadastro.add(endereco);

		patrimonios.addActionListener(this);

		// configuracoes basicas para ambas as telas
		janelaCadastro.setLayout(null);
		painelCadastro.setLayout(null);

		salvar.setBounds(20, 220, 100, 30);
		excluir.setBounds(360, 220, 100, 30);

		salvar.setBackground(cinzinha);
		excluir.setBackground(cinzinha);

		janelaCadastro.add(salvar);
		janelaCadastro.add(excluir);

		janelaCadastro.add(painelCadastro);
		janelaCadastro.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);
	}

	public void inserirEditar(int posf, int pos, ControleEmpresa c, int op, boolean novo) {
		telaSelecionada = 2;
		cEmpresa = c;
		this.op = op;
		fTemporaria = posf;
		pTemporaria = pos;

		janelaCadastro = new JFrame("Cadastro Patrimônio");
		janelaCadastro.setBounds(1025, 450, 500, 300);

		if (novo == true) {
			nome = new JTextField();
			valor = new JTextField();
			quantidade = new JTextField();

			if (op == 1) {
				tipo = new JTextField();
				area = new JTextField();
				endereco = new JTextField();
				CadastroPatrimonio("Imobiliario");
			}

			else if (op == 2) {
				descricao = new JTextField();
				funcao = new JTextField();
				CadastroPatrimonio("Utilitario");
			}

			else if (op == 3) {
				cor = new JTextField();
				modelo = new JTextField();
				fabricante = new JTextField();
				CadastroPatrimonio("Veiculo");
			}

		}

		else if (novo == false) {
			nome = new JTextField(cEmpresa.getFilial(fTemporaria).getPatrimonios().get(pos).getNome());
			valor = new JTextField(String.valueOf(cEmpresa.getFilial(fTemporaria).getPatrimonios().get(pos).getValor()));
			quantidade = new JTextField(String.valueOf(cEmpresa.getFilial(fTemporaria).getPatrimonios().get(pos).getQuantidade()));
			
			// Imobiliario
			if (op == 1) {
				tipo = new JTextField(cEmpresa.getControleFiliais().converterImobiliario(fTemporaria, pos).getTipo());
				area = new JTextField(String.valueOf(cEmpresa.getControleFiliais().converterImobiliario(fTemporaria, pos).getArea()));
				endereco = new JTextField(cEmpresa.getControleFiliais().converterImobiliario(fTemporaria, pos).getEndereco());
				CadastroPatrimonio("Imobiliario");
			}

			// Utilitario
			else if (op == 2) {
				descricao = new JTextField(cEmpresa.getControleFiliais().converterUtilitario(fTemporaria, pos).getDescricao());
				funcao = new JTextField(cEmpresa.getControleFiliais().converterUtilitario(fTemporaria, pos).getFuncao());
				CadastroPatrimonio("Utilitario");
			}

			// Veiculo
			else if (op == 3) {
				cor = new JTextField(cEmpresa.getControleFiliais().converterVeiculo(fTemporaria, pos).getCor());
				modelo = new JTextField(cEmpresa.getControleFiliais().converterVeiculo(fTemporaria, pos).getModelo());
				fabricante = new JTextField(cEmpresa.getControleFiliais().converterVeiculo(fTemporaria, pos).getFabricante());
				CadastroPatrimonio("Veiculo");
			}
		}

		imobiliario.setBounds(10, 15, 100, 20);
		utilitario.setBounds(185, 15, 100, 20);
		veiculo.setBounds(365, 15, 100, 20);

		imobiliario.setBackground(cinzinha);
		utilitario.setBackground(cinzinha);
		veiculo.setBackground(cinzinha);

		janelaCadastro.add(imobiliario);
		janelaCadastro.add(utilitario);
		janelaCadastro.add(veiculo);

		imobiliario.addActionListener(this);
		utilitario.addActionListener(this);
		veiculo.addActionListener(this);

		// configuracoes basicas para ambas as telas
		janelaCadastro.setLayout(null);
		painelCadastro.setLayout(null);

		salvar.setBounds(20, 220, 100, 30);
		excluir.setBounds(360, 220, 100, 30);

		salvar.setBackground(cinzinha);
		excluir.setBackground(cinzinha);

		janelaCadastro.add(salvar);
		janelaCadastro.add(excluir);

		janelaCadastro.add(painelCadastro);
		janelaCadastro.setVisible(true);

		salvar.addActionListener(this);
		excluir.addActionListener(this);
		
	}

	public void CadastroPatrimonio(String patri) {
		painelCadastro.removeAll();
		painelCadastro.setBounds(5, 30, 475, 190);

		textoNome.setFont(arial);
		textoNome.setBounds(67, 35, 100, 15);
		nome.setBounds(120, 35, 250, 20);

		if (patri.equals("Imobiliario")) {
			textoTipo.setFont(arial);
			textoValor.setFont(arial);
			textoArea.setFont(arial);
			textoEndereco.setFont(arial);

			textoTipo.setBounds(80, 65, 100, 20);
			tipo.setBounds(120, 65, 250, 20);
			textoValor.setBounds(50, 95, 100, 20);
			valor.setBounds(120, 95, 100, 20);
			textoArea.setBounds(230, 95, 200, 20);
			area.setBounds(275, 95, 75, 20);
			textoEndereco.setBounds(45, 125, 100, 20);
			endereco.setBounds(120, 125, 250, 20);

			painelCadastro.add(textoTipo);
			painelCadastro.add(tipo);
			painelCadastro.add(textoValor);
			painelCadastro.add(valor);
			painelCadastro.add(textoArea);
			painelCadastro.add(area);
			painelCadastro.add(textoEndereco);
			painelCadastro.add(endereco);
		}

		else if (patri.equals("Utilitario")) {
			textoDescricao.setFont(arial);
			textoFuncao.setFont(arial);
			textoValor.setFont(arial);
			textoQuantidade.setFont(arial);

			textoDescricao.setBounds(40, 65, 100, 20);
			descricao.setBounds(120, 65, 250, 20);
			textoFuncao.setBounds(60, 95, 100, 20);
			funcao.setBounds(120, 95, 250, 20);
			textoValor.setBounds(50, 125, 100, 20);
			valor.setBounds(120, 125, 95, 20);
			textoQuantidade.setBounds(220, 125, 200, 20);
			quantidade.setBounds(310, 125, 60, 20);

			painelCadastro.add(textoDescricao);
			painelCadastro.add(descricao);
			painelCadastro.add(textoFuncao);
			painelCadastro.add(funcao);
			painelCadastro.add(textoValor);
			painelCadastro.add(valor);
			painelCadastro.add(textoQuantidade);
			painelCadastro.add(quantidade);
		}

		else if (patri.equals("Veiculo")) {
			textoCor.setFont(arial);
			textoModelo.setFont(arial);
			textoFabricante.setFont(arial);
			textoValor.setFont(arial);
			textoQuantidade.setFont(arial);

			textoModelo.setBounds(60, 65, 100, 15);
			modelo.setBounds(120, 65, 270, 20);
			textoCor.setBounds(85, 95, 100, 20);
			cor.setBounds(120, 95, 80, 20);
			textoFabricante.setBounds(205, 95, 100, 20);
			fabricante.setBounds(290, 95, 100, 20);
			textoValor.setBounds(220, 125, 100, 20);
			valor.setBounds(290, 125, 100, 20);
			textoQuantidade.setBounds(30, 125, 200, 20);
			quantidade.setBounds(120, 125, 80, 20);

			nome.setBounds(120, 35, 270, 20);

			painelCadastro.add(textoCor);
			painelCadastro.add(cor);
			painelCadastro.add(textoModelo);
			painelCadastro.add(modelo);
			painelCadastro.add(textoFabricante);
			painelCadastro.add(fabricante);
			painelCadastro.add(textoValor);
			painelCadastro.add(valor);
			painelCadastro.add(textoQuantidade);
			painelCadastro.add(quantidade);
		}

		painelCadastro.add(textoNome);
		painelCadastro.add(nome);

		janelaCadastro.revalidate();
		janelaCadastro.repaint();
	}

	public void actionPerformed(ActionEvent event) {
		Boolean sucesso = true;
		if (event.getSource() == salvar) {
			if (telaSelecionada == 1) {
				String[] filial = new String[5];
				
				filial[0] = nome.getText();
				filial[1] = cnpj.getText();
				filial[2] = email.getText();
				filial[3] = telefone.getText();
				filial[4] = endereco.getText();
				
				sucesso = cEmpresa.cadastroFilial(filial, fTemporaria);
			}
			
			else if (telaSelecionada == 2) {
				String[] patrimonio = new String[6];
				
				patrimonio[0] = nome.getText();
				patrimonio[1] = valor.getText();
				//Imobiliario
				if(op == 1) {
					patrimonio[2] = tipo.getText();
					patrimonio[3] = area.getText();
					patrimonio[4] = endereco.getText();
					sucesso = cEmpresa.getControleFiliais().cadastroPatrimonio(patrimonio, fTemporaria, pTemporaria, 1);
				}
				
				//Utilitario
				else if(op == 2) {
					patrimonio[2] = descricao.getText();
					patrimonio[3] = funcao.getText();
					patrimonio[4] = quantidade.getText();
					sucesso = cEmpresa.getControleFiliais().cadastroPatrimonio(patrimonio, fTemporaria, pTemporaria, 2);
				}
				
				//Veiculo
				else if(op == 3) {
					
					patrimonio[2] = cor.getText();
					patrimonio[3] = modelo.getText();
					patrimonio[4] = fabricante.getText();
					patrimonio[5] = quantidade.getText();
					sucesso = cEmpresa.getControleFiliais().cadastroPatrimonio(patrimonio, fTemporaria, pTemporaria, 3);
				}
			}

			if (sucesso == true) 
				sucessoCadastro();
			
			else 
				erroCadastro();
			
			salvar.removeActionListener(this);
		}

		else if (event.getSource() == excluir) {
			if (telaSelecionada == 1) 
			cEmpresa.apagarFilial(fTemporaria);
			
			else if(telaSelecionada == 2)
				cEmpresa.getControleFiliais().apagarPatrimonio(pTemporaria, fTemporaria);
			
			sucessoExclusao();
		}

		else if (event.getSource() == patrimonios) {
			new TelaPatrimonio(cEmpresa, fTemporaria);
		}

		else if (event.getSource() == imobiliario) {
			janelaCadastro.dispose();
			inserirEditar(fTemporaria, pTemporaria, cEmpresa, 1, true);
		}

		else if (event.getSource() == utilitario) {
			janelaCadastro.dispose();
			inserirEditar(fTemporaria, pTemporaria, cEmpresa, 2, true);
		}

		else if (event.getSource() == veiculo) {
			janelaCadastro.dispose();
			inserirEditar(fTemporaria, pTemporaria, cEmpresa, 3, true);
		}
	}

	public void sucessoCadastro() {
		if(telaSelecionada == 1)
			JOptionPane.showMessageDialog(null, "Filial Cadastrada", null, JOptionPane.INFORMATION_MESSAGE);
		else 
			JOptionPane.showMessageDialog(null, "Patrimônio Cadastrado", null, JOptionPane.INFORMATION_MESSAGE);
		
		janelaCadastro.dispose();
	}

	public void erroCadastro() {
		if(telaSelecionada == 1)
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar filial", null, JOptionPane.ERROR_MESSAGE);
		else 
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar patrimônio", null, JOptionPane.ERROR_MESSAGE);
		
		janelaCadastro.dispose();
	}
	
	public void sucessoExclusao() {
		if(telaSelecionada == 1)
			JOptionPane.showMessageDialog(null, "Filial Removida", null, JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Patrimônio Removido", null, JOptionPane.ERROR_MESSAGE);
			
		janelaCadastro.dispose();
	}
}