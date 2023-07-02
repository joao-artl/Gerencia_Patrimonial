package modelo;

import java.util.*;

/**
 * Classe que representa uma empresa, contendo informacoes
 * basicas para a criacao da mesma, alem de possuir 
 * um ArrayList (lista) de filiais associadas a ela
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class Empresa {
	private String nome;
	private long cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private ArrayList<Filial> filiais = new ArrayList<Filial>();

	public Empresa() {
	}
	
	/**
	 * Construtor Empresa
	 * @param nome
	 * @param cnpj
	 * @param email
	 * @param telefone
	 * @param endereco
	 */

	public Empresa(String nome, long cnpj, String email,
			       long telefone, String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setFiliais(Filial filial) {
		filiais.add(filial);
	}

	public ArrayList<Filial> getFiliais() {
		return filiais;
	}

	/**
	 * Metodo que retorna um array de String
	 * com os nomes das filiais cadastradas
	 * @return String[]
	 */
	
	public String[] getNomesFiliais() {
		int t = filiais.size();
		String s[] = new String[t];
		int i = 0;
		for (Filial j : filiais) {
			s[i] = j.getNome();
			i++;
		}
		return s;
	}
	
	/**
	 * Metodo que retorna um array de String com
	 * os nomes de todos os patrimonios da empresa
	 * Percorre cada filial cadastrada e obtem os nomes
	 * de seus patrimonios, adicionando-os a um ArrayList
	 * e convertendo no final para o tipo especificado
	 * @return String[]
	 */

	public String[] listarTodosPatrimonios() {
		ArrayList<String> todosPatrimonios = new ArrayList<String>();
		for (Filial i : filiais) {
			for (ItemDePatrimonio j : i.getPatrimonios()) {
				todosPatrimonios.add(j.getNome());
			}
		}
		return todosPatrimonios.toArray(new String[0]);
	}
	
	/**
	 * Método que preenche o ArrayList de filiais com dados pre-cadastrados 
	 * Atribui, a cada interacao do for, informacoes a uma filial
	 */

	public void fillWithSomeData() {
		for (int l = 0; l < 5; l++) {
			Filial temporaria = new Filial();
			String nome = "Filial" + l;
			long cnpj = 62172900001060L + l;
			String email = "filial" + l + "@email.com";
			long telefone = 986243876 + l;
			String endereco = "endereco" + l;

			temporaria.setCnpj(cnpj);
			temporaria.setEmail(email);
			temporaria.setEndereco(endereco);
			temporaria.setNome(nome);
			temporaria.setTelefone(telefone);

			filiais.add(temporaria);
		}
	}

	public String toString() {
		return "============== Empresa " + nome + " ==============" + "\nCNPJ: " + cnpj
		  + "\nEmail: " + email + "\nTelefone: " + telefone + "\nEndereco: " + endereco;
	}
}