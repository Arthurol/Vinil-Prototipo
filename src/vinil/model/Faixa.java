package vinil.model;

public class Faixa {

	private int id;
	private String titulo;
	private int duracaoSegundos; 
	
	public int getId() 
	{
		return id;
	}
	public String getTitulo() 
	{
		return titulo;
	}
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	public int getDuracaoSegundos() 
	{
		return duracaoSegundos;
	}
	public void setDuracaoSegundos(int duracaoSegundos) 
	{
		this.duracaoSegundos = duracaoSegundos;
	}
}
