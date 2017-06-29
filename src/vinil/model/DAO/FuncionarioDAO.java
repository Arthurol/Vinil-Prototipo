package vinil.model.DAO;

import vinil.model.Autor;
import vinil.model.Funcionario;
import vinil.model.LongPlay;

import java.sql.*;
import java.util.Calendar;

public class FuncionarioDAO {

	Configurador config;
	
	public FuncionarioDAO()
	{
		config = new Configurador();
	}
	
	public int cadastrarFuncionario(Funcionario funcionario)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return -1;
	        }
	        
	        CallableStatement cs = conn.prepareCall("{? = call inserirfuncionario( ?, ?, ?, ?, ?, ? ) }");
	        cs.registerOutParameter(1, Types.INTEGER);
	        cs.setString(2, funcionario.getNome());
	        cs.setString(3, funcionario.getCpf());
	        cs.setString(4, funcionario.getEmail());
	        cs.setString(5, funcionario.getSenha());
	        cs.setString(6, funcionario.getCargo());
	        
	        if (funcionario.getInicioGerencia() == null)
	        	cs.setNull(7, Types.NULL);
	        else
	        	cs.setString(7, funcionario.getInicioGerencia().toString());
	        
	        cs.execute();
	        int retornoFuncao = cs.getInt(1);
	        cs.close();
	        return retornoFuncao;
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
		}
	}
	
	public boolean checaCredencial(String email, String senha)
	{
		FaixaDAO faixaDAO = new FaixaDAO();
		
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return false;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM funcionarios WHERE email = ? and senha = ?");
	        ps.setString(1, email);
	        ps.setString(2, senha);
	        
	        ResultSet rs = ps.executeQuery();
	        rs.close();
	        if (!rs.isBeforeFirst()) 
	        {    
	        	return false; 
	        }
	        	return true;

		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
	}
	
	public Funcionario getFuncionarioByEmail(String email)
	{
		try (Connection conn = config.conectar())
		{
	        if (conn == null) {
	            return null;
	        }
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT * FROM funcionarios WHERE email = ?");
	        ps.setString(1, email);
 	        ResultSet rs = ps.executeQuery();
	        
	        if (!rs.isBeforeFirst()) 
	        {    
	        	rs.close();
	        	return null;
	        }	
	       
	        return funcionarioFromResultSet(rs);
	        
		} catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
	}
	
	private Funcionario funcionarioFromResultSet(ResultSet rs) throws SQLException
	{
		rs.next();
		Funcionario funcionario = new Funcionario();
		funcionario.setId(rs.getInt("id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setCpf(rs.getString("cpf"));
		funcionario.setEmail(rs.getString("email"));
		funcionario.setCargo(rs.getString("cargo"));
		
		if (rs.getDate("inicio_gerencia") != null)
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime(rs.getDate("inicio_gerencia"));
			funcionario.setInicioGerencia(cal);
		}
		  
		funcionario.setSenha(rs.getString("senha"));
		rs.close();
		return funcionario;
	}
	
	public int alterarSenha(int idFuncionario, String novaSenha)
	{
		return 0;
	}
	
}
