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
	        
	        CallableStatement upperProc = conn.prepareCall("{? = call inserirgravadora( ?, ?, ?, ? ) }");
	        upperProc.registerOutParameter(1, Types.INTEGER);
	        upperProc.setString(2, gravadora.getNome());
	        upperProc.setString(3, gravadora.getCnpj());
	        upperProc.setString(4, gravadora.getEndereco());
	        
	        //String[] telefones = {);
	        
	        //for (int i = 0; i < gravadora.getTelefones().size(); i++)
	        //{
	        //	telefones[i] = gravadora.getTelefones().get(i);
	       // }
	        
	        Array arrayTelefones = conn.createArrayOf("text", gravadora.getTelefones().toArray());
	        
	        
	        upperProc.setArray(5, arrayTelefones);
	        upperProc.execute();
	        String retornoFuncao = upperProc.getString(1);
	        upperProc.close();
	        return Integer.parseInt(retornoFuncao);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
		
	}
	
}
