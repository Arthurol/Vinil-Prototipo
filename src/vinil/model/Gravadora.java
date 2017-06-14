package vinil.model;

import java.util.List;

public class Gravadora {

	private int id;
	private String nome;
	private String cnpj;
	private String endereco;
	private List<String> telefones;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getCnpj() 
	{
		return cnpj;
	}
	
	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}
	
	public String getEndereco() 
	{
		return endereco;
	}
	
	public void setEndereco(String endereco) 
	{
		this.endereco = endereco;
	}
	
	public List<String> getTelefones() 
	{
		return telefones;
	}
	
	public void setTelefones(List<String> telefones) 
	{
		this.telefones = telefones;
	}
	
	public int getId() 
	{
		return id;
	}
	
}
