package controle;

import java.util.ArrayList;

import modelo.*;

public class ControleEmpresa {
	private Empresa dados;
	private ControleFiliais cFiliais;

	public ControleEmpresa() {
		dados = new Empresa();
		cFiliais = new ControleFiliais(dados);
		dados.fillWithSomeData();
		fillFiliaisWithSomeData();
	}

	public void fillFiliaisWithSomeData() {
		int i = 0;
		for (Filial filial : dados.getFiliais()) {
			for (int l = 0; l < 5; l++) {
				ItemDePatrimonio temporaria;

				if (l == 0 && l == 3) {
					temporaria = new Imobiliario();
					((Imobiliario) temporaria).setTipo("Ap");
					((Imobiliario) temporaria).setArea(100 + (l + i));
					((Imobiliario) temporaria).setEndereco("SQN 32" + (l + i));
				}

				else if (l == 1 && l == 4) {
					temporaria = new Utilitario();
					((Utilitario) temporaria).setDescricao("top de bola" + (l + i));
					((Utilitario) temporaria).setFuncao("Armazenamento" + (l + i));
				}

				else {
					temporaria = new Veiculo();
					((Veiculo) temporaria).setCor("azul");
					((Veiculo) temporaria).setModelo("GT");
					((Veiculo) temporaria).setFabricante("Nissan");
				}

				String nome = "Item" + (l + i);
				double valor = 2000 + (l + i);
				int quantidade = (l + i);

				temporaria.setNome(nome);
				temporaria.setValor(valor);
				temporaria.setQuantidade(quantidade);

				filial.setPatrimonios(temporaria);
			}
			i += 5;
		}
	}

	public boolean cadastroFilial(String f[], int pos) {
		Filial filial = new Filial(f[0], Long.parseLong(f[1]), f[2], Long.parseLong(f[3]), f[4]);

		for (int i = 0; i < dados.getFiliais().size(); i++) {
			if (i == pos) {
				dados.getFiliais().set(pos, filial);
				return true;
			}
		}

		dados.setFiliais(filial);
		return true;
	}

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

	/*
	 * public String[] test() { return dados.listarTodosPatrimonios(); }
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
