package vinil.model;

public class Funcionario {

	private int id;
	private String nome;
	private String login;
	private String senha;
	private String cargo;
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getLogin() 
	{
		return login;
	}
	
	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getSenha() 
	{
		return senha;
	}
	
	public void setSenha(String senha) 
	{
		this.senha = senha;
	}
	
	public String getCargo() 
	{
		return cargo;
	}
	public void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}
	
	public int getId() {
		return id;
	}
}
