package modelo;

/**
 * Subclasse de ItemDePatrimonio, representa um item do tipo Veiculo
 * contendo informacoes especificas como cor, modelo e fabricante
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class Veiculo extends ItemDePatrimonio {
	private String cor;
	private String modelo;
	private String fabricante;
	
	public Veiculo() {
	}
	
	/**
	 * Construtor Veiculo
	 * @param nome
	 * @param cor
	 * @param modelo
	 * @param fabricante
	 * @param valor
	 * @param quantidade
	 */
	
	public Veiculo(String nome, String cor, String modelo,
				   String fabricante, double valor, int quantidade) {
		super();
		this.nome = nome;
		this.cor = cor;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getFabricante() {
		return fabricante;
	}

	@Override
	public String toString() {
		return "\n -Veiculo-" + "\n Item: " + nome + "\n Cor: " + cor +
			   "\n Modelo: " + modelo + "\n Fabricante: " + fabricante +
			   "\n Valor: R$ " + valor + "\n Quantidade: " + quantidade;
	}
}
