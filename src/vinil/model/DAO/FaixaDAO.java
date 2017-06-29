package vinil.model.DAO;

import java.util.ArrayList;
import java.util.List;

import vinil.model.Autor;
import vinil.model.Faixa;
import vinil.model.LongPlay;

import java.sql.*;

public class FaixaDAO {

Configurador config;
	
	public FaixaDAO()
	{
		config = new Configurador();
	}
	
	public Faixa getFaixaById(int idFaixa)
	{
		return null;
	}
	
	public List<Faixa> getFaixasByLongPlay(int idLongPlay)
	{
		 String idsFaixas = "";
		 List<Faixa> faixas = new ArrayList<Faixa>();
		
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps1 = conn.prepareStatement("SELECT * FROM faixas_longplay WHERE id_longplay = ?");
	        ps1.setInt(1, idLongPlay);
	        ResultSet rs1 = ps1.executeQuery();
	        
	        int contador = 0;
	        while (rs1.next())
	        {
	        	if (contador == 0)
	        		idsFaixas = String.valueOf(rs1.getInt("id_faixa"));
	        	else
	        		idsFaixas += ", " + String.valueOf(rs1.getInt("id_faixa"));
	        	
	        	contador++;
	        }
	        rs1.close();
	        
	        
	        PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM faixas WHERE id in (" + idsFaixas + ")");
	        ResultSet rs2 = ps2.executeQuery();
	        
	        return listaFaixasFromResultSet(rs2);
	        
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	private List<Faixa> listaFaixasFromResultSet(ResultSet rs) throws SQLException {
		List<Faixa> listaFaixas = new ArrayList<Faixa>();
		
		while(rs.next())
		{
			Faixa faixa = new Faixa();
			faixa.setId(rs.getInt("id"));
			faixa.setTitulo(rs.getString("titulo"));
			faixa.setDuracaoSegundos(rs.getInt("duracao_segundos"));
			faixa.setCompositoresLetra(rs.getString("compositores_letra"));
			listaFaixas.add(faixa);
		}
		rs.close();
		return listaFaixas;
	}

	public List<Faixa> getFaixasByAutor(int idAutor)
	{
		return null;
	} 
	
	public int adicionaFaixa(Faixa faixa)
	{
		return 0;
	}
		
}
