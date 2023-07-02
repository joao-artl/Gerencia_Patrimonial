package controle;

import java.util.ArrayList;
import modelo.*;

/**
 * Classe que controla os metodos da classe Empresa e simula um banco de dados
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class ControleEmpresa {
	private Empresa dados;
	private ControleFiliais cFiliais;

	/**
	 * Construtor da Classe
	 */
	public ControleEmpresa() {
		dados = new Empresa();
		cFiliais = new ControleFiliais(dados);
		dados.fillWithSomeData();
		fillWithSomeDataDeFiliais();
	}

	/**
	 * Metodo que serve para preencher cada filial com patrimonios pre-cadastrados, 
	 * usando um laço de repeticao para preencher o ArrayList 
	 */
	
	public void fillWithSomeDataDeFiliais() {
		int i = 0;
		for (Filial filial : dados.getFiliais()) {
			for (int l = 0; l < 5; l++) {
				ItemDePatrimonio temporaria;

				if (l == 0 || l == 3) {
					temporaria = new Imobiliario();
					((Imobiliario) temporaria).setTipo("Apartamento");
					((Imobiliario) temporaria).setArea(100 + (l + i));
					((Imobiliario) temporaria).setEndereco("SQN " + (100 + l + i) + ", Bloco " + (char) (l + 65));
				}

				else if (l == 1 || l == 4) {
					temporaria = new Utilitario();
					((Utilitario) temporaria).setDescricao("top de bola");
					((Utilitario) temporaria).setFuncao("Armazenamento");
				}

				else {
					temporaria = new Veiculo();
					((Veiculo) temporaria).setCor("azul");
					((Veiculo) temporaria).setModelo("GTR");
					((Veiculo) temporaria).setFabricante("Nissan");
				}

				String nome = "Item" + (l + i);
				double valor = 2000 + ((l + i) * 1.7);
				int quantidade = (l + i);

				temporaria.setNome(nome);
				temporaria.setValor(valor);
				temporaria.setQuantidade(quantidade);

				filial.setPatrimonios(temporaria);
			}
			i += 5;
		}
	}

	/**
	 * Este metodo verifica se todos os campos de cadastro foram preenchidos e, em seguida,
	 * verifica se a posicao recebida possui uma filial ja cadastrada. Se nao houver uma
	 * filial cadastrada na posicao especificada, uma nova filial e salva.
	 * 
	 * @param f  vetor de String que recebe os dados da filial a ser cadastrada
	 * @param pos  um inteiro que indica a posicao em que essa filial deve ser cadastrada/editada no ArrayList
	 * @return boolean
	 */
	
	public boolean cadastrarEditarFilial(String f[], int pos) {
		if (f[0].matches("^$|^\\s*$") || !f[1].matches("[0-9]+") || f[2].matches("^$|^\\\\s*$")
				|| !f[3].matches("[0-9]+") || f[4].matches("^$|^\\\\s*$"))
			return false;

		else {
			Filial filial = new Filial(f[0], Long.parseLong(f[1]), f[2], Long.parseLong(f[3]), f[4]);
			for (int i = 0; i < dados.getFiliais().size(); i++) {
				if (i == pos) {
					ArrayList<ItemDePatrimonio> existentes = dados.getFiliais().get(pos).getPatrimonios();
					dados.getFiliais().set(pos, filial);
					
					dados.getFiliais().get(pos).setPatrimonios(existentes);
					return true;
				}
			}

			dados.setFiliais(filial);
			return true;
		}
	}

	/**
	 * Metodo que recebe o indice de uma filial e o usa para apaga-la do ArrayList
	 * de filiais
	 * 
	 * @param x  o int x corresponde ao indice da filial a ser excluida
	 */
	
	public void apagarFilial(int x) {
		dados.getFiliais().remove(x);
	}

	public Empresa getDados() {
		return dados;
	}

	public void setDados(Empresa dados) {
		this.dados = dados;
	}

	public Filial getFilial(int index) {
		return dados.getFiliais().get(index);
	}

	public ControleFiliais getControleFiliais() {
		return cFiliais;
	}

	/**
	 * Metodo que recebe uma String e procura o patrimonio corresponde a ela e
	 * retorna a posicao da filial, do patrimonio e o tipo do patrimonio
	 * 
	 * @param nome  String que corresponde ao nome do patrimonio buscado
	 * @return int[] - onde a posicao 0 corresponde a filial, a posição 1 corresponde
	 * ao patrimonio e a posicao 2 corresponde ao tipo de patrimonio
	 * (1 para Imobiliario, 2 para Utilitario e 3 para Veiculo)
	 */
	
	public int[] procurarPatrimonio(String nome) {
		for (int i = 0; i < dados.getFiliais().size(); i++) {
			Filial filial = dados.getFiliais().get(i);
			ArrayList<ItemDePatrimonio> patrimonios = filial.getPatrimonios();

			for (int j = 0; j < patrimonios.size(); j++) {
				ItemDePatrimonio patrimonio = patrimonios.get(j);

				if (patrimonio.getNome().equals(nome)) {
					int[] posicoes = new int[3];
					posicoes[0] = i;
					posicoes[1] = j;

					if (patrimonio instanceof Imobiliario)
						posicoes[2] = 1;
					if (patrimonio instanceof Utilitario)
						posicoes[2] = 2;
					if (patrimonio instanceof Veiculo)
						posicoes[2] = 3;

					return posicoes;
				}
			}
		}
		return null;
	}
}
