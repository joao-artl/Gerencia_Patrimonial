package controle;

import modelo.*;
import visao.*;

import java.util.*;

public class ControleEmpresa {
	private TelaCadastro tela;
	private Empresa dados = new Empresa();
	
	public ControleEmpresa() {
		dados.fillWithSomeData();
	}
	
	public void cadastroFilial() {
		dados.setFiliais(tela.adicionarFilial());
	}
	
	public Empresa getDados() {
		return dados;
	}
	
	public void setDados(Empresa dados) {
		this.dados = dados;
	}
	
	
}
