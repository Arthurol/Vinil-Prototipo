package vinil.model;

public class Autor {
	
	private int id;
	private String nome;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Autor()
	{
		this.id = -1;
		this.nome = "";
	}
	
	public Autor(String nome)
	{
		this.nome = nome;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
}
