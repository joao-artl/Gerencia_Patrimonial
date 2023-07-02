package modelo;

/**
 * Classe abstrada que representa um item de patrimonio, 
 * contendo informacoes basicas de um item, como 
 * nome, valor e quantidade
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public abstract class ItemDePatrimonio {
	protected String nome;
	protected double valor;
	protected int quantidade;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}
}