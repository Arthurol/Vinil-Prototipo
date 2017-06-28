package vinil.model;

import java.util.Calendar;
import java.util.List;

public class LongPlay {

	private int id;
	private String titulo;
	private List<Integer> idAutores;
	private int anoGravacao;
	private int idGravadora;
	private int idSecao;
	private String genero;
	private int quantidadeEstoque;
	private double preco;
	private List<Faixa> faixas;
	
	public LongPlay()
	{
		this.id = -1;
		this.titulo = "";
		this.idAutores = null;
		this.anoGravacao = -1;
		this.idGravadora = -1;
		this.idSecao = -1;
		this.genero = "";
		this.quantidadeEstoque = 0;
		this.preco = 0.0;
		this.faixas = null;
	}
	
	//Construtor com id da seção
	public LongPlay(String titulo, List<Integer> idAutores, int anoGravacao, int idGravadora, int idSecao, String genero, int quantidadeEstoque, double preco, List<Faixa> faixas)
	{
		this.titulo = titulo;
		this.idAutores = idAutores;
		this.anoGravacao = anoGravacao;
		this.idGravadora = idGravadora;
		this.idSecao = idSecao;
		this.genero = genero;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
		this.faixas = faixas;
	}
	
	//Construtor sem id da seção
	public LongPlay(String titulo, List<Integer> idAutores, int anoGravacao, int idGravadora, String genero, int quantidadeEstoque, double preco, List<Faixa> faixas)
	{
		this.titulo = titulo;
		this.idAutores = idAutores;
		this.anoGravacao = anoGravacao;
		this.idGravadora = idGravadora;
		this.genero = genero;
		this.quantidadeEstoque = quantidadeEstoque;
		this.preco = preco;
		this.faixas = faixas;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}
	
	public List<Integer> getIdAutores() {
		return idAutores;
	}

	public void setIdAutores(List<Integer> idAutores) {
		this.idAutores = idAutores;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}
	
	public int getAnoGravacao()
	{
		return anoGravacao;
	}
	
	public void setAnoGravacao(int anoGravacao)
	{
		this.anoGravacao = anoGravacao;
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

	public int getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(int idSecao) {
		this.idSecao = idSecao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(List<Faixa> faixas) {
		this.faixas = faixas;
	}
}
