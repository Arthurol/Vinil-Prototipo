package vinil.model.DAO;

import java.sql.*;
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
	        
	        CallableStatement upperProc = conn.prepareCall("{? = call inserirautor( ? ) }");
	        upperProc.registerOutParameter(1, Types.INTEGER);
	        upperProc.setString(2, autor.getNome());
	        upperProc.execute();
	        String retornoFuncao = upperProc.getString(1);
	        upperProc.close();
	        return Integer.parseInt(retornoFuncao);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
		
	}
	
	public List<Autor> getAutoresByLongPlay(int idLongPlay)
	{
		return null;
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
