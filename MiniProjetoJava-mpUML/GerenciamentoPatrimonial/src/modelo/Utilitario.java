package modelo;

public class Utilitario extends ItemDePatrimonio {
	private String descricao;
	private String funcao;
	
	public Utilitario() {
		super();
	}
	
	public Utilitario(String nome, String descricao, String funcao, double valor, int quantidade) {
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
		return "\n -Utilitario-" + "\n Item: " + nome + "\n Descricao: " + descricao +
			   "\n Funcao: " + funcao + "\n Valor: R$ " + valor + "\n Quantidade: " + quantidade;
	}
}
