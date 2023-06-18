package controle;

import modelo.*;
public class ControleFiliais {
	private Filial dados = new Filial();
	
	public ControleFiliais() {
		dados.fillWithSomeData();
	}
	
	public Filial getDados() {
		return dados;
	}
}
