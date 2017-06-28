package vinil.model.DAO;

import vinil.model.Autor;
import vinil.model.Gravadora;
import java.sql.*;

public class GravadoraDAO {

Configurador config;
	
	public GravadoraDAO()
	{
		config = new Configurador();
	}
	
	public int adicionarGravadora(Gravadora gravadora)
	{
		
		
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirgravadora( ?, ?, ?, ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, gravadora.getNome());
	        cs.setString(3, gravadora.getCnpj());
	        cs.setString(4, gravadora.getEndereco());
	        
	        Array arrayTelefones = conn.createArrayOf("text", gravadora.getTelefones().toArray());
	        
	        cs.setArray(5, arrayTelefones);
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
		
	}
	
}
