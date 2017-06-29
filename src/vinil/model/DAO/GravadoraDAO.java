package vinil.model.DAO;

import vinil.model.Autor;
import vinil.model.Gravadora;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public List<Gravadora> listagemGravadoras()
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM gravadoras");
	        ResultSet rs = ps.executeQuery();
	        
	        
	        
	        return listaGravadorasFromResultSet(rs);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	private List<Gravadora> listaGravadorasFromResultSet(ResultSet rs) throws SQLException
	{
		List<Gravadora> listaGravadoras = new ArrayList<Gravadora>();
		
		 if (!rs.isBeforeFirst()) 
	        {    
	        	rs.close();
	        	return null;
	        }	
		
		while(rs.next())
		{
			Gravadora gravadora = new Gravadora();
			gravadora.setId(rs.getInt("id"));
			gravadora.setNome(rs.getString("nome"));
			gravadora.setCnpj(rs.getString("cnpj"));
			gravadora.setEndereco(rs.getString("endereco"));
			
			Array a = rs.getArray("telefones");
			String[] stringvet  = (String[])  a.getArray();
			List<String> telefones = new ArrayList<String>(Arrays.asList(stringvet));
			
			gravadora.setTelefones(telefones);
			listaGravadoras.add(gravadora);
		}
		
		rs.close();
		return listaGravadoras;
	}
}
