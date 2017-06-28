package vinil.model;

public class Secao {

	private int id;
	private String genero;
	private int status;
	
	public Secao(String genero)
	{
		this.genero = genero;
	}
	
	public String getGenero() 
	{
		return genero;
	}
	
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}
	
	public int getStatus() 
	{
		return status;
	}
	
	public void setStatus(int status) 
	{
		this.status = status;
	}
	
	public int getId() 
	{
		return id;
	}
}
