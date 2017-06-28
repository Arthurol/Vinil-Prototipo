package vinil.model.DAO;

import java.util.List;
import vinil.model.LongPlay;
import vinil.model.Secao;
import java.sql.*;

public class SecaoDAO {
	
	Configurador config;
	
	public SecaoDAO()
	{
		config = new Configurador();
	}
	
	public List<LongPlay> getLongPlaysBySecao(int id)
	{
		return null;
	}
	
	public int adicionaLongPlayNaSecao(LongPlay longPlay, int idSecao)
	{
		return 0;
	}
	
	public int adicionaSecao(Secao secao)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirsecao( ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, secao.getGenero());
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
