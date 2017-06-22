package vinil.model;

import java.util.Calendar;

public class Funcionario {

	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String cargo;
	private Calendar inicioGerencia;
	
	public Funcionario()
	{
		this.id = -1;
		this.nome = "";
		this.cpf = "";
		this.email = "";
		this.senha = "";
		this.cargo = "";
		this.inicioGerencia = null;
	}
	
	public Funcionario(String nome, String cpf, String email, String senha, String cargo, Calendar inicioGerencia)
	{
		this.nome = nome;
		this.setCpf(cpf);
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.inicioGerencia = inicioGerencia;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
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
	
	public Calendar getInicioGerencia() {
		return inicioGerencia;
	}

	public void setInicioGerencia(Calendar inicioGerencia) {
		this.inicioGerencia = inicioGerencia;
	}

}
