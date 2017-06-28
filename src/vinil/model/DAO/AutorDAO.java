package vinil.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vinil.model.Autor;


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
		
		return autor;
	}
	
	private List<Autor> listaAutoresFromResultSet(ResultSet rs) throws SQLException
	{
		List<Autor> listaAutores = new ArrayList<Autor>();
		
		while(rs.next())
		{
			Autor autor = new Autor();
			autor.setId(rs.getInt("id"));
			autor.setNome(rs.getString("nome"));
			listaAutores.add(autor);
		}
		return listaAutores;
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
