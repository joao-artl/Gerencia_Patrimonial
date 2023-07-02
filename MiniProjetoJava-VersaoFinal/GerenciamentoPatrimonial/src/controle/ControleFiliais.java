package controle;

import modelo.*;

/**
 * Classe que controla os metodos da classe Filial e simula banco de dados
 * @author Joao Artur Leles Ferreira Pinheiro e Weverton Rodrigues da Costa Silva
 * @since 2023
 * @version 1.0
 */

public class ControleFiliais {
	private Empresa empresa;

	/**
	 * Construtor da classe
	 * @param empresa
	 */
	public ControleFiliais(Empresa empresa) {
		this.empresa = empresa;
	}

	/**
	 * Metodo que verifica a qual tipo de patrimonio um determinado item pertence
	 * 
	 * @param posF  posicao da filial no ArrayList
	 * @param posP  posicao do patrimonio no ArrayList
	 * @return int  indica o tipo de patrimonio (1 para Imobiliario, 2 para Utilitario e 3 para Veiculo)
	 */
	public int verificarInstancia(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);

		int op = 0;
		if (item instanceof Imobiliario)
			op = 1;
		if (item instanceof Utilitario)
			op = 2;
		if (item instanceof Veiculo)
			op = 3;

		return op;
	}

	/**
	 * Metodo que faz o cast de um ItemDePatrimonio para Imobiliario
	 * 
	 * @param posF  posicao da filial no ArrayList
	 * @param posP  posicao do patrimonio no ArrayList
	 * @return Imobiliario
	 */
	public Imobiliario converterImobiliario(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Imobiliario) item;
	}

	/**
	 * Metodo que faz o cast de um ItemDePatrimonio para Utilitario
	 * 
	 * @param posF  posicao da filial no ArrayList
	 * @param posP  posicao do patrimonio no ArrayList
	 * @return Utilitario
	 */
	public Utilitario converterUtilitario(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Utilitario) item;
	}

	/**
	 * Metodo que faz o cast de um ItemDePatrimonio para Veiculo
	 * 
	 * @param posF  posicao da filial no ArrayList
	 * @param posP  posicao do patrimonio no ArrayList
	 * @return Veiculo
	 */
	public Veiculo converterVeiculo(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Veiculo) item;
	}

	/**
	 * Metodo que cadastra um patrimonio
	 * 
	 * @param p  vetor de String com os dados do patrimonio
	 * @param posF  indica a posicao da filial no ArrayList
	 * @param posP  indica a posicao do patrimonio no ArrayList
	 * @param op  indica o tipo de patrimonio
	 * @return boolean
	 */
	public boolean cadastroPatrimonio(String[] p, int posF, int posP, int op) {
		if (p[0].matches("^$|^\\s*$") || p[1].matches("[a-zA-Z]+") || p[2].matches("^$|^\\s*$")
				|| p[3].matches("^$|^\\s*$") || p[4].matches("^$|^\\s*$"))
			return false;

		else {
			Filial filial = empresa.getFiliais().get(posF);
			ItemDePatrimonio patrimonio;

			switch (op) {
			case 1:
				patrimonio = new Imobiliario(p[0], p[2], Double.parseDouble(p[3]), Double.parseDouble(p[1]), p[4]);
				break;
			case 2:
				patrimonio = new Utilitario(p[0], p[2], p[3], Double.parseDouble(p[1]), Integer.parseInt(p[4]));
				break;
			case 3:
				patrimonio = new Veiculo(p[0], p[2], p[3], p[4], Double.parseDouble(p[1]), Integer.parseInt(p[5]));
				break;
			default:
				return false;
			}

			if (posP >= filial.getPatrimonios().size())
				filial.setPatrimonios(patrimonio);
			else
				filial.getPatrimonios().set(posP, patrimonio);
			return true;
		}
	}

	/**
	 * Metodo que recebe dois int e remove um patrimonio do ArrayList
	 * 
	 * @param x  corresponde ao indice do patrimonio selecionado
	 * @param f  corresponde ao indice da filial que possui o patrimonio selecionado
	 */
	public void apagarPatrimonio(int x, int f) {
		empresa.getFiliais().get(f).getPatrimonios().remove(x);
	}
}