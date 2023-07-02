package modelo;

/**
 * Subclasse de ItemDePatrimonio, representa um item do tipo Utilitario
 * contendo informacoes especificas como descricao e funcao
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class Utilitario extends ItemDePatrimonio {
	private String descricao;
	private String funcao;
	
	public Utilitario() {
	}
	
	/**
	 * Construtor Utilitario
	 * @param nome
	 * @param descricao
	 * @param funcao
	 * @param valor
	 * @param quantidade
	 */
	
	public Utilitario(String nome, String descricao, String funcao,
					  double valor, int quantidade) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.funcao = funcao;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	public String getFuncao() {
		return funcao;
	}

	@Override
	public String toString() {
		return "\n -Utilitario-" + "\n Item: " + nome + "\n Descricao: " +
			   descricao + "\n Funcao: " + funcao + "\n Valor: R$ " +
				valor + "\n Quantidade: " + quantidade;
	}
}
