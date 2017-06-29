package vinil.model.DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import vinil.model.Autor;
import vinil.model.Faixa;
import vinil.model.Funcionario;
import vinil.model.LongPlay;

public class LongPlayDAO {
	
	Configurador config;
	
	public LongPlayDAO()
	{
		config = new Configurador();
	}

	public LongPlay getLongPlayById(int idLongPlay)
	{
		FaixaDAO faixaDAO = new FaixaDAO();
		
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM longplays WHERE id = ?");
	        ps.setInt(1, idLongPlay);
	        ResultSet rs = ps.executeQuery();
	        
	        LongPlay longPlay = longPlayFromResultSet(rs);
	        longPlay.setFaixas(faixaDAO.getFaixasByLongPlay(idLongPlay));
	        return longPlay;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public List<LongPlay> getLongPlaysByTitulo(String titulo)
	{
		FaixaDAO faixaDAO = new FaixaDAO();
		LongPlay longPlay = null;
		List<LongPlay> listaLps = new ArrayList<LongPlay>();
		
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM longplays WHERE titulo like ?");
	        ps.setString(1, "%" + titulo + "%");
	        ResultSet rs = ps.executeQuery();
	        
	        if (!rs.isBeforeFirst())
	        {
	        	rs.close();
	        	return null;
	        }
	        
	        while(rs.next())
	        {
	        	longPlay = longPlayFromResultSet(rs);
	        	longPlay.setFaixas(faixaDAO.getFaixasByLongPlay(longPlay.getId()));
	        	listaLps.add(longPlay);
	        }
	        return listaLps;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	public int adicionaLongPlay(LongPlay longPlay)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirlongplay( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, longPlay.getTitulo());
	        
	        Array arrayAutores = conn.createArrayOf("int", longPlay.getIdAutores().toArray());
	        cs.setArray(3, arrayAutores);
	        
	        cs.setInt(4, longPlay.getAnoGravacao());
	        cs.setInt(5, longPlay.getIdGravadora());
	        cs.setInt(6, longPlay.getIdSecao() > 0 ? longPlay.getIdSecao() : -1);
	        cs.setString(7, longPlay.getGenero());
	        cs.setInt(8, longPlay.getQuantidadeEstoque());
	        cs.setDouble(9, longPlay.getPreco());
	        
	        List<String> titulosFaixas = new ArrayList<String>();
	        List<String> compositoresFaixas = new ArrayList<String>();
	        List<Integer> duracoesFaixas = new ArrayList<Integer>();
	        
	        for (int i = 0; i < longPlay.getFaixas().size(); i ++)
	        {
	        	titulosFaixas.add(longPlay.getFaixas().get(i).getTitulo());
	        	compositoresFaixas.add(longPlay.getFaixas().get(i).getCompositoresLetra());
	        	duracoesFaixas.add(longPlay.getFaixas().get(i).getDuracaoSegundos());
	        }
	        
	        Array arrayTitulosFaixas = conn.createArrayOf("text", titulosFaixas.toArray());
	        Array arrayDuracoesFaixas = conn.createArrayOf("int", duracoesFaixas.toArray());
	        Array arrayCompositoresFaixas = conn.createArrayOf("text", compositoresFaixas.toArray());
	        
	        cs.setArray(10, arrayTitulosFaixas);
	        cs.setArray(11, arrayDuracoesFaixas);
	        cs.setArray(12, arrayCompositoresFaixas);
	        
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
		}
	}
	
	public int editarLongPlay(int idLongPlay, LongPlay longPlay)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call editarlongplay( ?, ?, ?, ?, ?, ?) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setInt(2, idLongPlay);
	        cs.setString(3, longPlay.getTitulo());
	        cs.setInt(4, longPlay.getAnoGravacao());
	        cs.setString(5, longPlay.getGenero());
	        cs.setInt(6, longPlay.getQuantidadeEstoque());
	        cs.setDouble(7, longPlay.getPreco());
	        
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
		}
	}
	
	public int removeLongPlay(int idLongPlay)
	{
		return 0;
	}
	
	private LongPlay longPlayFromResultSet(ResultSet rs) throws SQLException {
		LongPlay longPlay = new LongPlay();
		longPlay.setId(rs.getInt("id"));
		longPlay.setTitulo(rs.getString("titulo"));
		longPlay.setAnoGravacao(rs.getInt("ano_gravacao"));
		longPlay.setIdGravadora(rs.getInt("gravadora"));
		longPlay.setGenero(rs.getString("genero"));
		longPlay.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
		longPlay.setPreco(rs.getDouble("preco"));
		
		return longPlay;
	}
	
	public List<LongPlay> getLongPlaysByAutor(int idAutor)
	{
		return null;
	}
}
