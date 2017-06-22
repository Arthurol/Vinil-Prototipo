package vinil.model;

import java.util.Calendar;

public class LongPlay {

	private int id;
	private String titulo;
	private Calendar dataGravacao;
	private int idGravadora;
	private String genero;
	private int quantidadeEstoque;
	
	public LongPlay()
	{
		
	}
	
	public String getTitulo() 
	{
		return titulo;
	}
	
	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	public Calendar getDataGravacao()
	{
		return dataGravacao;
	}
	
	public void setDataGravacao(Calendar dataGravacao)
	{
		this.dataGravacao = dataGravacao;
	}
	
	public int getIdGravadora() 
	{
		return idGravadora;
	}
	
	public void setIdGravadora(int idGravadora) 
	{
		this.idGravadora = idGravadora;
	}
	
	public String getGenero() 
	{
		return genero;
	}
	
	public void setGenero(String genero) 
	{
		this.genero = genero;
	}
	
	public int getQuantidadeEstoque() 
	{
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(int quantidadeEstoque) 
	{
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public int getId() 
	{
		return id;
	}
}
