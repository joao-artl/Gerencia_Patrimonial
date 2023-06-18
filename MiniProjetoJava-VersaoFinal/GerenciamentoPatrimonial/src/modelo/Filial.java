package modelo;

import java.util.*;

public class Filial {
	private String nome;
	private long cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private ArrayList<ItemDePatrimonio> patrimonios = new ArrayList<ItemDePatrimonio>();
	
	public Filial() {
	}
	
	public Filial(String nome, long cnpj, String email, long telefone, String endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setTelefone (long telefone) {
		this.telefone = telefone;
	}
	
	public long getTelefone() {
		return telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setPatrimonios(ItemDePatrimonio novoPatrimonio){
		patrimonios.add(novoPatrimonio);
	}
	
	public ArrayList<ItemDePatrimonio> getPatrimonios(){
		return patrimonios;
	}
	
	public String[] getNomesPatrimonios() {
		int t = patrimonios.size();
		String s[] = new String[t];
		int i = 0;
		for(ItemDePatrimonio j: patrimonios) { 
			s[i] = j.getNome();
			i++;
		}
		return s;
	}
	
	//@Override
    public String toString() {
        return  "\n---- Filial " + nome + " ----" + "\nCNPJ: " + cnpj + "\nEmail: " +
        	    email + "\nTelefone: " + telefone + "\nEndereco: " + endereco;
    }
    
    //talvez seja melhor colocar isso na controle
    public boolean verificacaoCadastro(Filial filial)	{
		if(filial.getNome() == null ||  filial.getEmail() == null || filial.getEndereco() == null) {
			return false;
		}
		else {
			return true;
		}
    }
    
    public void fillWithSomeData() {
        for (int l = 0; l < 5; l++) {
            ItemDePatrimonio temporaria;
            
            if (l % 3 == 0) {
            	temporaria = new Imobiliario(null, null, 0, 0, null);
            	((Imobiliario) temporaria).setTipo("Ap");
                ((Imobiliario) temporaria).setArea(100 + l);
                ((Imobiliario) temporaria).setEndereco("SQN 32" + l);
            } 
            
            else if (l % 3 == 1) {
            	temporaria = new Utilitario(null, null, null, 0, 0);
            	((Utilitario) temporaria).setDescricao("top de bola" + l);
                ((Utilitario) temporaria).setFuncao("Armazenamento" + l);
            } 
            
            else {
                temporaria = new Veiculo(null, null, null, null, 0, 0);
                ((Veiculo) temporaria).setCor("azul");
                ((Veiculo) temporaria).setModelo("GT");
                ((Veiculo) temporaria).setFabricante("Nissan");
            }
            
            String nome = "Item" + l;
            double valor = 2000 + l;
            int quantidade = l;

            temporaria.setNome(nome);
            temporaria.setValor(valor);
            temporaria.setQuantidade(quantidade);

            patrimonios.add(temporaria);
        }
    }
}
    