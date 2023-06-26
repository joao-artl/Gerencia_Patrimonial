package controle;

import modelo.*;

public class ControleFiliais {
	private Empresa empresa;

	public ControleFiliais(Empresa empresa) {
		this.empresa = empresa;
	}

	public Imobiliario converterImobiliario(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Imobiliario) item;
	}

	public Utilitario converterUtilitario(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Utilitario) item;
	}

	public Veiculo converterVeiculo(int posF, int posP) {
		ItemDePatrimonio item = empresa.getFiliais().get(posF).getPatrimonios().get(posP);
		return (Veiculo) item;
	}

	public Boolean cadastroPatrimonio(String[] p, int posF, int posP, int op) {
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

		Filial filial = empresa.getFiliais().get(posF);

		for (int i = 0; i < filial.getPatrimonios().size(); i++) {
			if (i == posP) {
				filial.getPatrimonios().set(posP, patrimonio);
				return true;
			}
		}

		filial.setPatrimonios(patrimonio);
		return true;
	}

	public void apagarPatrimonio(int x, int f) {
		empresa.getFiliais().get(f).getPatrimonios().remove(x);
	}
}