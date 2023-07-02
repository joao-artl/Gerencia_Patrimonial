package modelo;

import java.util.*;

/**
 * Classe que representa uma filial, contendo informacoes
 * basicas para a criacao da mesma, alem de possuir 
 * um ArrayList (lista) de patrimonios associados a ela
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class Filial {
	private String nome;
	private long cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private ArrayList<ItemDePatrimonio> patrimonios = new ArrayList<ItemDePatrimonio>();

	public Filial() {
	}
	
	/**
	 * Construtor Filial
	 * @param nome
	 * @param cnpj
	 * @param email
	 * @param telefone
	 * @param endereco
	 */

	public Filial(String nome, long cnpj, String email,
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

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setPatrimonios(ItemDePatrimonio novoPatrimonio) {
		patrimonios.add(novoPatrimonio);
	}

	public ArrayList<ItemDePatrimonio> getPatrimonios() {
		return patrimonios;
	}

	/**
	 * Metodo que retorna um array de String
	 * com os nomes de todos os patrimonios da filial
	 * Percorre cada patrimonio cadastrado e obtem
	 * seu respectivo nome
	 * @return String[]
	 */
	
	public String[] getNomesPatrimonios() {
		int t = patrimonios.size();
		String s[] = new String[t];
		int i = 0;
		for (ItemDePatrimonio j : patrimonios) {
			s[i] = j.getNome();
			i++;
		}
		return s;
	}

	// @Override
	public String toString() {
		return "\n---- Filial " + nome + " ----" + "\nCNPJ: " + cnpj + "\nEmail: " + email
				+ "\nTelefone: " + telefone + "\nEndereco: " + endereco;
	}
}
