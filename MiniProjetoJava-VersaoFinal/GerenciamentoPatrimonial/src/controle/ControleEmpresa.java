package controle;

import modelo.*;
import visao.*;

import java.util.*;

public class ControleEmpresa {
	public TelaCadastro tela = new TelaCadastro(1);
	public Empresa dados;
	
	public void cadastroFilial() {
		dados.setFiliais(tela.inserirEditar());
	}
	public Empresa getDados() {
		return dados;
	}

	public void setDados(Empresa dados) {
		this.dados = dados;
	}
	
}
