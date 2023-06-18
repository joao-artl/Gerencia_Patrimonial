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
	
	public void cadastroFilial(Filial f) {
		dados.setFiliais(f);
	}
	public void apagarFilial(int x){
		dados.getFiliais().remove(x);
	}
	public Empresa getDados() {
		return dados;
	}
	
	public void setDados(Empresa dados) {
		this.dados = dados;
	}
	
	
}
