package vinil.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vinil.model.Autor;
import vinil.model.Gravadora;


public class AutorDAO {

	Configurador config;
	
	public AutorDAO()
	{
		config = new Configurador();
	}
	
	public int adicionarAutor(Autor autor)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirautor( ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, autor.getNome());
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
		
	}

	public Autor getAutorById(int idAutor)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autores WHERE id = ?");
	        ps.setInt(1, idAutor);
	        ResultSet rs = ps.executeQuery();
	        
	        return autorFromResultSet(rs);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public Autor getAutorByName(String nomeAutor)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autores WHERE nome like ? limit 1");
	        ps.setString(1, "%" + nomeAutor + "%");
	        ResultSet rs = ps.executeQuery();
	        
	        return autorFromResultSet(rs);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public List<Autor> getAutoresByLongPlay(int idLongPlay)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autores_longplay WHERE id_longplay = ?");
	        ps.setInt(1, idLongPlay);
	        ResultSet rs = ps.executeQuery();
	        
	        //vai retornar uma lista de autores a partir de um id de lp
	        return listaAutoresFromResultSet(rs);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}

	private Autor autorFromResultSet(ResultSet rs) throws SQLException
	{
		rs.next();
		Autor autor = new Autor();
		autor.setId(rs.getInt("id"));
		autor.setNome(rs.getString("nome"));
		rs.close();
		return autor;
	}
	
	private List<Autor> listaAutoresFromResultSet(ResultSet rs) throws SQLException
	{
		List<Autor> listaAutores = new ArrayList<Autor>();
		List<Integer> idsAutores = new ArrayList<Integer>();
		while(rs.next())
		{
			idsAutores.add(rs.getInt("id_autor"));
		}
		rs.close();
		
		for (int i = 0; i < idsAutores.size(); i++)
		{
			listaAutores.add(getAutorById(idsAutores.get(i)));
		}
		
		return listaAutores;
	}
	
	public List<Autor> listagemAutores()
	{
		List<Autor> autores = new ArrayList<Autor>();
	
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM autores");
	        ResultSet rs = ps.executeQuery();
	        
	        while (rs.next())
	        {
	        	autores.add(new Autor(rs.getInt("id"), rs.getString("nome")));
	        }
	        rs.close();
	        return autores;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
		
	
	/*
	public int removerAutor(int idAutor)
	{
		return 0;
	}
	
	public int editarAutor(int idAutor, Autor autor)
	{
		return 0;
	}
	*/
}
