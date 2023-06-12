package modelo;

import java.util.*;

public class Empresa {
	private String nome;
	private long cnpj;
	private String email;
	private long telefone;
	private String endereco;
	private ArrayList<Filial> filiais = new ArrayList<Filial>();
	
	public Empresa(String nome, long cnpj, String email,
				   long telefone, String endereco) {
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
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	
	public long getTelefone() {
		return telefone;
	}

	public void setFiliais(Filial filial) {
		filiais.add(filial);
	}
	
	public ArrayList<Filial> getFiliais() {
		return filiais;
	}
	
	/*
	public ArrayList<ItemDePatrimonio> listarTodosPatrimonios() {
		ArrayList<ItemDePatrimonio> todosPatrimonios = new ArrayList<ItemDePatrimonio>();
		for(Filial i: filiais) {
			todosPatrimonios.addAll(i.getPatrimonios());
		}
		return todosPatrimonios;
	}
	*/
	
	//lista os patrimonios por nome
	public ArrayList<String> listarTodosPatrimonios() {
		ArrayList<String> todosPatrimonios = new ArrayList<String>();
		for(Filial i: filiais) {
			for(ItemDePatrimonio j: i.getPatrimonios()) {
				todosPatrimonios.add(j.getNome());	
			}
		}
		return todosPatrimonios;
	}
	
	
	public ItemDePatrimonio buscarPatrimonio(String busca) {
		ItemDePatrimonio encontrado;
		for(Filial i: filiais) {
			for(ItemDePatrimonio j: i.getPatrimonios()) {
				if(j.getNome().equals(busca)) {
					encontrado = j;
					return encontrado;
				}
			}
		}
		return null;
	}	
	
	public String toString() {
		return "============== Empresa " + nome + " ==============" +
			   "\nCNPJ: "+ cnpj + "\nEmail: " + email + "\nTelefone: " +
			   telefone + "\nEndereco: " + endereco;
	}
}