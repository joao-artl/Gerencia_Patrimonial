package modelo;

import java.util.*;

public class Filial {
	private String nome;
	private long cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private ArrayList<ItemDePatrimonio> patrimonios = new ArrayList<ItemDePatrimonio>();
	
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
	
	//@Override
    public String toString() {
        return  "\n---- Filial " + nome + " ----" + "\nCNPJ: " + cnpj + "\nEmail: " +
        	    email + "\nTelefone: " + telefone + "\nEndereco: " + endereco;
    }
    
    public boolean verificacaoCadastro(Filial filial)	{

		if(filial.getNome() == null ||  filial.getEmail() == null || filial.getEndereco() == null) {
			return false;
		}
		else {
			return true;
		}
    }}
    