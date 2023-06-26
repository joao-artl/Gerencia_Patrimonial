package modelo;

public class Imobiliario extends ItemDePatrimonio {
	private double area;
	private String tipo;
	private String endereco;
	
	public Imobiliario() {
	}
	
	public Imobiliario(String nome, String tipo, double area, double valor, String endereco) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.area = area;
		this.valor = valor;
		this.endereco = endereco;
		this.quantidade = 1;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}


	@Override
	public String toString() {
		return "\n -Imobiliario-" + "\n Tipo: " + tipo + "\n Endereco: " +
				endereco + "\n Complemento: " + nome + "\n Area: " + area +
				" metros quadrados" + "\n Valor: R$ " + valor;
	}
}
