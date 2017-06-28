package vinil.model;

public class Faixa {

	private int id;
	private String titulo;
	private int duracaoSegundos; 
	private String compositoresLetra;
	
	public Faixa()
	{
		this.id = -1;
		this.titulo = "";
		this.duracaoSegundos = -1;
		this.compositoresLetra = "";
	}
	
	public Faixa(String titulo, int duracaoSegundos, String compositoresLetra)
	{
		this.titulo = titulo;
		this.duracaoSegundos = duracaoSegundos;
		this.compositoresLetra = compositoresLetra;
	}
	
	public Faixa(String titulo, String compositoresLetra)
	{
		this.titulo = titulo;
		this.compositoresLetra = compositoresLetra;
	}
	
	public void setId(int id) {
		this.id = id;
	}

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

	public String getCompositoresLetra() {
		return compositoresLetra;
	}

	public void setCompositoresLetra(String compositoresLetra) {
		this.compositoresLetra = compositoresLetra;
	}
}
