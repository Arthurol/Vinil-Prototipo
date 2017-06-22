package vinil.model.DAO;

import java.sql.*;
import java.util.Properties;

public class Configurador {

	public Connection conectar() throws SQLException{
        Connection conexao;
        
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/vinil";
        	Properties props = new Properties();
        	props.setProperty("user","postgres");
        	props.setProperty("password","postgres");
        	props.setProperty("database", "vinil");
        	conexao = DriverManager.getConnection(url, props);
        	return conexao;

        } catch (SQLException e)
        {
            System.out.println("A conexão com o banco de dados falhou - erro de SQL");
            System.out.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e)
        {
            System.out.println("A conexão com o banco de dados falhou - driver não encontrado");
            return null;
        }
	}
}
